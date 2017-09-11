/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		18/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.Scanner;	/* Used for the Scanner to get user input */

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
	 * The method isValidNumberOfTestCases checks whether the number of test cases
	 * to perform is within allowed limits.
	 * @param numberOfTestCases The integer number of test cases to perform.
	 * @return True if the value is within the allowed limits, otherwise false.
	 */
	public static boolean isValidNumberOfTestCases(int numberOfTestCases)
	{
		return ( 1 <= numberOfTestCases ) && ( numberOfTestCases <= 100000 );
	}


	/**
	 * The method isValidTestCase checks whether the value provided for a test case
	 * is within allowed limits.
	 * @param testCase The integer value provided for a test case
	 * @return True if the value is within the allowed limits, otherwise false.
	 */
	public static boolean isValidTestCase(int testCase)
	{
		return ( 1 <= testCase ) && ( testCase <= 1000000000 );
	}


	/**
	 * The method calculateNumberOfZeros calculates the number of trailing
	 * zeros which will appear at the end of the factorial of n.
	 * @param n The integer to perfgorm the operation for.
	 * @return The integer number of trailing zeros which will appear at the end of the factorial of n.
	 */
	public static int calculateNumberOfZeros(int n)
	{
		int x=5, total=0;

		while( x <= n ) {
			total += n/x;
			x *= 5;
		}

		return total;
	}


	public static void main(String[] args)
	{
		int numberOfTestCases;
		int testCase;

		System.out.println("For any positive integer N, Z(N) is the number of zeros \n" +
				"at the end of the decimal form of number N!.\n" +
				"This program will calculate that value for each test case entered.\n\n");


		/* Input the number of test cases which will be entered */
		System.out.print("Enter number of test cases to perform > ");
		numberOfTestCases = getPositiveInteger();

		while(!isValidNumberOfTestCases(numberOfTestCases)) {
			System.out.println("Error - number of test cases must be between 1 and 100000.");
			System.out.print("Enter a valid number of test cases > ");
			numberOfTestCases = getPositiveInteger();
		}

		/* Input the values for the test cases, calculate the number of trailing zeros,
		 * and add the result to the answers array */
		int answers[] = new int[ numberOfTestCases ];

		for(int i=0; i<numberOfTestCases; i++)
		{
			System.out.print("Enter test case value > ");
			testCase = getPositiveInteger();

			while(!isValidTestCase(testCase)) {
				System.out.println("Error - value of test case must be between 1 and 1000000000.");
				System.out.print("Enter test case value > ");
				testCase = getPositiveInteger();
			}

			answers[i] = calculateNumberOfZeros(testCase);
		}

		/* Display the results stored in the answers array */
		System.out.println("\nResults:");
		for(int i=0; i<numberOfTestCases; i++)
			System.out.println(answers[i]);
	}
}
