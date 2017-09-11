/**
 * Filename:    Solution1.java
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        16/08/2017.
 * Description: SPOJ Exercise - see README.md
 * To do:       Use a linked-list, queue or stack to store the wrong guesses
 *              because there is the potential for an overflow.
 *              Add a GUI.
 */


import java.util.Scanner;   /* Used for the Scanner to get user input */

public class Solution1
{
    private static int meaningOfLife = 42;
    private static Scanner keyboard = new Scanner(System.in);


    /**
     * The method isTheMeaningOfLife returns true if the user has
     * correctly guessed the Meaning of Life, otherwise false
     * @param guess The user's guess at the Meaning of Life
     * @return A boolean
     */
    private static boolean isTheMeaningOfLife(int guess)
    {
        return guess==meaningOfLife;
    }


    /**
     * The method getPositiveInteger returns a positive integer input by the user.
     * @return A positive integer.
     */
    public static int getPositiveInteger()
    {
        String input;
        boolean isValidInt = false;
        int positiveInteger = 0;

        input = keyboard.nextLine();

        // Validate the user's input. If a valid positive integer has not been entered
        // display an error message and ask for the user to input a valid number
        while(!isValidInt)
        {
            try {
                positiveInteger = Integer.parseInt(input);

                // If the user has entered a valid positive integer the while loop can be exited
                if(positiveInteger>=0)
                    isValidInt = true;
                else
                {
                    // Display an error message and get new input from the user.
                    System.out.println("<<< ERROR - the Meaning of Life is Positive >>>\n");
                    System.out.print("What is the meaning of life? > ");
                    input = keyboard.nextLine();
                }
            }
            catch(Exception e)
            {
                // Display an error message and get new input from the user.
                System.out.println("<<< ERROR - invalid input >>>\n");
                System.out.print("What is the meaning of life? > ");
                input = keyboard.nextLine();
            }
        }

        return positiveInteger;
    }


    /**
     * The method printIntroduction displays the program's introduction text to the user.
     */
    public static void printIntroduction()
    {
        String intro = "    TEST - Life, the Universe, and Everything\n\n" +
                "In this program you will guess the meaning of life.\n" +
                "I will ask you to enter the number which represents\n" +
                "the meaning of life. If you guess correctly, I will\n" +
                "let you know and then show you all of your previous\n" +
                "attempts. If however you have guessed incorrectly, I\n" +
                "will continue to ask you for the Meaning of Life until\n" +
                "you either guess it correctly, rage quit the program,\n" +
                "or run out of memory space and crash the program.\n\n" +
                "OK then... let us begin.\n";

        System.out.println(intro);
    }


    /**
     * The method runUserInputLoop is used to get the user's guesses as to
     * the Meaning of Life and store them into the array passed. When the
     * user correctly guesses the Meaning of Life the program will return the
     * number of wrong guesses made.
     * @param previousGuesses An array to store wrong guesses made by the user.
     * @return The number of wrong guesses made.
     */
    public static int runUserInputLoop(int previousGuesses[])
    {
        int userGuess=0;
        int count = 0;

        System.out.print("What is the meaning of life? > ");
        userGuess = getPositiveInteger();

        while( !isTheMeaningOfLife(userGuess) )
        {
            previousGuesses[count++] = userGuess;
            System.out.print("What is the meaning of life? > ");
            userGuess = getPositiveInteger();
        }

        return count;
    }


    /**
     * The method printWrongGuesses displays to the user the wrong guesses which
     * they made whilst attempting to guess the Meaning of Life.
     * @param wrongGuesses An array containing the wrong guesses made by the user.
     * @param numberOfGuesses The number of wrong guesses made by the user.
     */
    public static void printWrongGuesses(int wrongGuesses[], int numberOfGuesses)
    {
        if(numberOfGuesses > 0) {
            System.out.println("In your quest you made the following wrong guesses:\n");

            for (int i=0; i<numberOfGuesses; i++) {
                System.out.printf("%10d\n",wrongGuesses[i] );
            }
        }
        else
            System.out.println("Correct at the first attempt! You must be a Level 12 Wizard.");
    }


    public static void main(String[] args)
    {
        int previousGuesses[] = new int[200];
        int numberOfGuesses;

        printIntroduction();
        numberOfGuesses = runUserInputLoop(previousGuesses);

        System.out.println("\nIndeed the Meaning of Life is " + meaningOfLife + ".\n");
        printWrongGuesses(previousGuesses, numberOfGuesses);
    }
}
