/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        03/09/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.math.BigInteger;
import java.util.Scanner;

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
     * The method getPositiveBigInteger returns an integer input by the user.
     * @return A positive BigInteger.
     */
    private static BigInteger getPositiveBigInteger()
    {
        String input;
        boolean isValidInt = false;
        BigInteger validatedInteger = new BigInteger("0");

        input = keyboard.nextLine();

        // Validate the user's input. If a valid positive integer has not been entered
        // display an error message and ask for the user to input a valid number
        while(!isValidInt)
        {
            try {
                validatedInteger = new BigInteger(input);
                if(validatedInteger.compareTo( new BigInteger("0")) < 0)
                {
                    System.out.println("<<< ERROR - must be a positive number >>>\n");
                    System.out.print("Enter a valid number > ");
                    validatedInteger = new BigInteger(input);
                }
                else
                    isValidInt = true;
            }
            catch(Exception e)
            {
                // Display an error message and get new input from the user.
                System.out.println("<<< ERROR - must be a valid number >>>\n");
                System.out.print("Enter a valid number > ");
                input = keyboard.nextLine();
            }
        }

        return validatedInteger;
    }


    /**
     * The method isValidTestCaseValue checks whether the value to be used in
     * a test case is within allowed limits.
     * @param testCaseValue The value to be used for a test case.
     * @return True if the value is within the allowed limits, otherwise false.
     */
    public static boolean isValidTestCaseValue( BigInteger testCaseValue )
    {
        boolean result = testCaseValue.compareTo( new BigInteger("1")) >= 0 &&
                testCaseValue.compareTo( new BigInteger("2000000000000")) <= 0;
        if(!result)
            System.out.println("Error - Test case value must be in the range 1 to 2000000000000");
        return result;
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
            System.out.println("Error - Number of test cases must be in the range 1 to 10");
        return result;
    }


    /**
     * The method getTestCaseValue allows the user to input, and
     * return the value for a test case.
     * @return The value for a test case.
     */
    private static BigInteger getTestCaseValue()
    {
        BigInteger testCaseValue;

        System.out.print( "Enter value for test case > " );
        testCaseValue = getPositiveBigInteger();

        while(!isValidTestCaseValue( testCaseValue ))
        {
            System.out.print( "Enter value for test case > " );
            testCaseValue = getPositiveBigInteger();
        }

        return testCaseValue;
    }


    /**
     * The method calculateTestResult calculates and returns the nth number whose cube
     * ends in 888.
     * @param testCaseValue The ordinal of the nth cube ending in 888 to find the cube root for.
     * @return The nth number whose cube ends in 888.
     */
    private static BigInteger calculateTestResult( BigInteger testCaseValue )
    {
        BigInteger result = new BigInteger("192");
        result = result.add( new BigInteger("250").multiply( testCaseValue.subtract( new BigInteger("1")) ));

        return result;
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


    public static void main(String[] args)
    {
        System.out.println("1030 EIGHTS - Triple Fat Ladies\n" +
                "\n" +
                "Pattern Matchers have been designed for various sorts of patterns. Mr. HKP likes to observe\n" +
                "patterns in numbers.  After completing his extensive research on the squares of numbers,\n" +
                "he has moved on to cubes. Now he wants to know all numbers whose cube ends in 888.\n" +
                "\n" +
                "Given a number k, this program will help Mr. HKP find the kth number (indexed from 1)\n" +
                "whose cube ends in 888.\n");


        int numberOfTestCases = getNumberOfTestCases();
        BigInteger testCaseValue;

        BigInteger answers[] = new BigInteger[numberOfTestCases];

        for( int i=0; i<numberOfTestCases; i++ )
        {
            testCaseValue = getTestCaseValue();
            answers[i] = calculateTestResult(testCaseValue);
        }

        System.out.println("\n---- Results ----");
        int i=1;
        for(BigInteger bi : answers)
        {
            System.out.println( bi );
        }
    }
}
