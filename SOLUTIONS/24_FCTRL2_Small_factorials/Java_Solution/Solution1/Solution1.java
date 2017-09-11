/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		18/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.Scanner;	/* Used for the Scanner to get user input */
import java.math.*;

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
					System.out.println("<<< ERROR - input must be a positive integer >>>\n");
					System.out.print("Enter a positive integer > ");
					input = keyboard.nextLine();
				}
			}
			catch(Exception e)
			{
				// Display an error message and get new input from the user.
				System.out.println("<<< ERROR - input must be a positive integer >>>\n");
				System.out.print("Enter a positive integer > ");
				input = keyboard.nextLine();
			}
		}

		return positiveInteger;
	}


	/**
	 * The method isValidValue returns true if n has a valid value,
	 * otherwise false.
	 * @param n An integer to check whether it has a valid value.
	 * @return True if n has a valid value, otherwise false.
	 */
	public static boolean isValidValue(int n)
	{
		return ( ( n>=1 ) && ( n<=100 ) );
	}


	/**
	 * The method factorial calculates and returns the factorial
	 * of the integer n passed to it.
	 * @param n An integer to calculate the factorial for.
	 * @return The calculated factorial of the integer n.
	 */
	public static BigInteger factorial(int n)
	{
		BigInteger total = BigInteger.valueOf(1);
		for( int i=1; i<=n; i++ )
			total = total.multiply(BigInteger.valueOf(i));

		return total;
	}


	public static void main(String[] args)
	{
		int numberOfTestCases;
		int testCase;

		System.out.println("For each integer test case (n) given at input, this\n" +
						   "program will display a line with the value of n!.\n");


		/* Input the number of test cases which will be entered */
		System.out.print("Enter number of test cases to perform > ");
		numberOfTestCases = getPositiveInteger();

		while(!isValidValue(numberOfTestCases)) {
			System.out.println("Error - number of test cases must be between 1 and 100.");
			System.out.print("Enter a valid number of test cases > ");
			numberOfTestCases = getPositiveInteger();
		}

		/* Input the values for the test cases, calculate the number of trailing zeros,
		 * and add the result to the answers array */
		BigInteger answers[] = new BigInteger[ numberOfTestCases ];

		for(int i=0; i<numberOfTestCases; i++)
		{
			System.out.print("Enter test case value > ");
			testCase = getPositiveInteger();

			while(!isValidValue(numberOfTestCases)) {
				System.out.println("Error - value of test case must be between 1 and 100.");
				System.out.print("Enter test case value > ");
				testCase = getPositiveInteger();
			}

			answers[i] = factorial(testCase);
		}

		/* Display the results stored in the answers array */
		System.out.println("\nResults:");
		for(int i=0; i<numberOfTestCases; i++)
			System.out.println(answers[i]);
	}
}
