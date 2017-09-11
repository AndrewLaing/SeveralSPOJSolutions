/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        27/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.Scanner;   /* Used for the Scanner to get user input */

public class Solution1 {

    private static Scanner keyboard = new Scanner(System.in);

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
                    System.out.println("<<< ERROR - Number must be a Positive Integer >>>\n");
                    System.out.print("Enter a positive number > ");
                    input = keyboard.nextLine();
                }
            }
            catch(Exception e)
            {
                // Display an error message and get new input from the user.
                System.out.println("<<< ERROR - Number must be a Positive Integer >>>\n");
                System.out.print("Enter a positive number > ");
                input = keyboard.nextLine();
            }
        }

        return positiveInteger;
    }


    /**
     * The method isValidNumberOfSquares checks whether the number of sides
     * is within allowed limits.
     * @param squares The number of squares available.
     * @return True if the number of squares is within allowed limits,
     *         otherwise false.
     */
    private static boolean isValidNumberOfSquares( int squares )
    {
        boolean result = ( 1 <= squares) && ( squares <= 10000 );
        if(!result)
            System.out.print("Error - Number of squares must be in the range 1-10000");
        return result;
    }


    /**
     * The method calculateResult calculates the number of rectangles that
     * can be created from n squares.
     * @param n The number of squares available.
     * @return The number of rectangles that can be created from n squares.
     */
    private static int calculateResult( int n )
    {
        int total = n;
        int mul = 2;

        while( mul <= n/2 )
        {
            for( int i=mul; i<=(n/mul); i++ )
                total++;
            mul++;
        }

        return total;
    }


    /**
     * The method getNumberOfCandies allows the user to input, and
     * return a valid number of candies.
     * @return A valid number of candies.
     */
    private static int getNumberOfSquares()
    {
        int numberOfSquares;

        System.out.print( "Enter number of squares available > " );
        numberOfSquares = getPositiveInteger();

        while(!isValidNumberOfSquares( numberOfSquares ))
        {
            System.out.println( "Enter number of squares available > " );
            numberOfSquares = getPositiveInteger();
        }

        return numberOfSquares;
    }


    public static void main(String[] args)
    {
        System.out.println("\uFEFF4300 AE00 - Rectangles\n" +
                "\n" +
                "Byteman has a collection of N squares of size 1. \n" +
                "How many different rectangles can he form using these squares?\n" +
                "This program will help in solving that question.\n " +
                "\n" +
                "Two rectangles are considered different if none of them can be rotated \n" +
                "and moved to obtain the second one. During rectangle construction, \n" +
                "Byteman can neither deform the squares nor put any squares upon any other ones.\n\n");

        int numberOfSquaresAvailable = getNumberOfSquares();
        System.out.println("The answer is " + calculateResult( numberOfSquaresAvailable) );
    }
}
