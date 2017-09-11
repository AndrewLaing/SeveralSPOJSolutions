/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        24/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.*;   /* Used for the Scanner and List */

public class Solution1
{
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
     * The extractHotnessLevels method takes a String of n numbers separated
     * by a space, extracts the numbers, converts them to ints, and places
     * them into the out array.
     * @param in A string containing two numbers separated by a space.
     * @param out An int array to store the extracted numbers in.
     * @param n The number of numbers to extract
     * @return True if the operation was successful, otherwise false.
     */
    public static boolean extractHotnessLevels(String in, int out[], int n)
    {
        String s[] = in.split(" ");
        int level;

        if(s.length != n)
            return false;

        try {
            for(int i = 0 ; i < n ; i++) {
                level = Integer.parseInt( s[i] );
                if(isValidHotnessLevel(level))
                    out[i] = level;
                else {
                    return false;
                }
            }
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }


    /**
     * The method isValidNumberOfTestCases checks whether the number of test cases
     * to perform is within allowed limits.
     * @param numberOfTestCases The integer number of test cases to perform.
     * @return True if the value is within the allowed limits, otherwise false.
     */
    public static boolean isValidNumberOfTestCases(int numberOfTestCases)
    {
        boolean res = ( 1 <= numberOfTestCases ) && ( numberOfTestCases <= 100 );
        if(!res)
            System.out.println("Error - Number of test cases must be in the range 1-100");

        return res;
    }


    /**
     * The method isValidNumberOfParticipants checks whether the number of participants
     * to be supplied for each gender is within allowed limits.
     * @param n A number representing the number of participants to be supplied
     *          for each gender.
     * @return True if the value is within the allowed limits, otherwise false.
     */
    public static boolean isValidNumberOfParticipants(int n)
    {
        boolean res = ( 1 <= n ) && ( n <= 1000 );
        if(!res)
            System.out.println("Error - Number of participants must be in the range 1-1000");

        return res;
    }


    /**
     * The method isValidHotnessLevel checks whether the hotness level supplied
     * to is within allowed limits.
     * @param hotnessLevel A number representing a persons hotness level.
     * @return True if the value is within the allowed limits, otherwise false.
     */
    public static boolean isValidHotnessLevel(int hotnessLevel)
    {
        boolean res = ( 0 <= hotnessLevel ) && ( hotnessLevel <= 10 );
        if(!res)
            System.out.println("Error - hotness levels must be between 0 and 10");

        return res;
    }


    public static int calculateScore(int arrMen[], int arrFem[], int arrLen)
    {
        if(arrMen.length != arrLen || arrFem.length != arrLen)
            return -1;

        int score = 0;
        int i;
        for(i=0; i<arrLen; i++)
            score += arrMen[i] * arrFem[i];

        return score;
    }


    /**
     * The method getNumberOfTestCases allows the user to input, and
     * return a valid number of test cases.
     * @return A valid number of test cases.
     */
    private static int getNumberOfTestCases()
    {
        int numberOfTestCases;

        System.out.print("\nEnter number of test cases > ");
        numberOfTestCases = getPositiveInteger();

        while( !isValidNumberOfTestCases(numberOfTestCases) )
        {
            System.out.print("\nEnter number of test cases > ");
            numberOfTestCases = getPositiveInteger();
        }

        return numberOfTestCases;
    }


    /**
     * The method getNumberOfTestCases allows the user to input, and
     * return a valid number of test cases.
     * @return A valid number of test cases.
     */
    private static int getNumberOfParticipants()
    {
        int numberOfParticipants;

        System.out.print("\nEnter number of participants per gender > ");
        numberOfParticipants = getPositiveInteger();

        while( !isValidNumberOfParticipants(numberOfParticipants) )
        {
            System.out.print("Enter number of participants per gender > ");
            numberOfParticipants = getPositiveInteger();
        }

        return numberOfParticipants;
    }


    /**
     * The method getSumOfHotnessBonds inputs the data for the test cases, calculates
     * the sum of the hotness bonds between the male and female participants, and
     * stores the results in the results array.
     * @param numberOfTestCases The number of test cases to input and calculate data for.
     * @param results The int array to store the results in.
     */
    public static void getSumOfHotnessBonds( int numberOfTestCases, int results[] )
    {
        String input;
        boolean scoresEnteredCorrectly;

        for( int i=0; i<numberOfTestCases; i++ )
        {
            int participants = getNumberOfParticipants();
            int arrMen[] = new int[participants];
            int arrFem[] = new int[participants];

            scoresEnteredCorrectly = false;

            while( scoresEnteredCorrectly==false )
            {
                System.out.print("Enter male hotness scores > ");
                input = keyboard.nextLine();

                if(extractHotnessLevels(input, arrMen, participants) != false)
                {
                    System.out.print("Enter female hotness scores > ");
                    input = keyboard.nextLine();

                    if(extractHotnessLevels(input, arrFem, participants) != false)
                    {
                        results[i] = calculateScore(arrMen, arrFem, participants );
                        scoresEnteredCorrectly = true;
                    }
                    else
                        System.out.println("Error - there must be " + participants + " hotness scores entered per line");
                }
                else
                {
                    System.out.println("Error - there must be " + participants + " hotness scores entered per line");
                }
            }
        }
    }


    public static void main(String[] args)
    {
        int numberOfTestCases;

        System.out.println("FEFF1025 FASHION - Fashion Shows\n" +
                "\n" +
                "A fashion show rates participants according to their level of hotness. \n" +
                "Two different fashion shows were organized, one for men and the other for women. \n" +
                "A date for the third is yet to be decided ;) .\n" +
                "\n" +
                "Now the results of both fashion shows are out. \n" +
                "The participants of both the fashion shows have decided to date each other, \n" +
                "but as usual they have difficulty in choosing their partners. \n" +
                "The Maximum Match dating serive (MMDS) comes to their rescue and matches them \n" +
                "in such a way that that maximizes the hotness bonds for all couples.\n" +
                "\n" +
                "If a man has been rated at hotness level x and a women at hotness level y, \n" +
                "the value of their hotness bond is x*y.\n" +
                "\n" +
                "Both fashion shows contain N participants each. \n" +
                "This program will find the sum of hotness bonds for all the couples \n" +
                "that MMDS has proposed.");


        numberOfTestCases = getNumberOfTestCases();

        int results[] = new int[numberOfTestCases];
        getSumOfHotnessBonds( numberOfTestCases, results );

        System.out.println("\n---- Results ----");
        for(int i : results)
            System.out.println(i);
    }
}
