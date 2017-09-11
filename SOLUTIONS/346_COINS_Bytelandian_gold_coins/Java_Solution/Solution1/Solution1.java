/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        29/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.Scanner;

public class Solution1
{
    private static Scanner keyboard = new Scanner( System.in );

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
     * The method getPositiveLongInteger returns a positive integer input by the user.
     * @return A positive long integer.
     */
    public static long getPositiveLongInteger()
    {
        String input;
        boolean isValidInt = false;
        long positiveInteger = 0;

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
     * The method isValidNumberOfTestCases checks whether the number of test cases
     * to perform is within allowed limits.
     * @param numberOfTestCases The integer number of test cases to perform.
     * @return True if the value is within the allowed limits, otherwise false.
     */
    public static boolean isValidNumberOfTestCases(int numberOfTestCases)
    {
        boolean result = ( 1 <= numberOfTestCases ) && ( numberOfTestCases <= 10 );
        if(!result)
            System.out.print("Error - Number of test cases must be in the range 1 to 10");
        return result;
    }

    /**
     * The method isValidNumberOfCoins validates that a valid number
     * of coins has been entered.
     * @param coins The integer number of coin.
     * @return True if a valid number of coins has been entered,
     *         otherwise false.
     */
    private static boolean isValidCoinValue(long coins)
    {
        boolean result = ( 1<=coins ) && ( coins<=1000000000 );
        if(!result)
            System.out.print("Error - Coin value must be in the range 1 to 1,000,000,000");
        return result;
    }

    /**
     * The method getValueOfCoin allows the user to input, and
     * return the value of a Bytelandian gold goin.
     * @return The value of a Bytelandian gold goin.
     */
    private static long getValueOfCoin()
    {
        long valueOfCoin;

        System.out.print( "Enter value of coin > " );
        valueOfCoin = getPositiveInteger();

        while(!isValidCoinValue( valueOfCoin ))
        {
            System.out.print( "Enter value of coin > " );
            valueOfCoin= getPositiveInteger();
        }

        return valueOfCoin;
    }


    /**
     * The method getNumberOfTestCases allows the user to input, and
     * return the number of test cases to perform.
     * @return The number of test cases to perform.
     */
    private static int getNumberOfTestCases()
    {
        int numberOfTestCases;

        System.out.print( "Enter number of test cases > " );
        numberOfTestCases = getPositiveInteger();

        while(!isValidNumberOfTestCases( numberOfTestCases ))
        {
            System.out.print( "Enter number of test cases > " );
            numberOfTestCases= getPositiveInteger();
        }

        return numberOfTestCases;
    }


    private static long convertToDollars( long n )
    {
        long res = 0;

        if (n > 2)
            res += n/2;
        else {
            res += n;
            return res;
        }

        if (n > 3)
            res += n/3;
        else {
            res += n;
            return res;
        }

        if (n > 4)
            res += n/4;
        else
            res += n;

        return res;
    }



    public static void main(String[] args)
    {
        System.out.println("346 COINS - Bytelandian gold coins\n" +
                "\n" +
                "In Byteland they have a very strange monetary system.\n" +
                "Each Bytelandian gold coin has an integer number written on it. \n" +
                "A coin n can be exchanged in a bank into three coins: \n" +
                "    n/2, n/3 and n/4. \n" +
                "\n" +
                "But these numbers are all rounded down (the banks have to make a profit).\n" +
                "\n" +
                "You can also sell Bytelandian coins for American dollars. \n" +
                "The exchange rate is 1:1. But you can not buy Bytelandian coins.\n" +
                "\n" +
                "You have one gold coin. \n" +
                "In this program you will enter the value of a number of coins and " +
                "will be shown the number of American dollars you can get for them.");


        int numberOfTestCases;
        long valueOfCoin;

        numberOfTestCases = getNumberOfTestCases();
        long answers[] = new long[numberOfTestCases];

        for( int i=0; i<numberOfTestCases; i++ )
        {
            valueOfCoin = getValueOfCoin();
            answers[i] = convertToDollars(valueOfCoin);
        }

        System.out.println("\n---- Results ----\n");
        for(long i : answers)
            System.out.println(i);
    }
}
