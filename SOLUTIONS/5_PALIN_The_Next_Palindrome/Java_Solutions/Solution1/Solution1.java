/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		08/09/2017.
 * Description:
 */

import java.util.Scanner;
import java.math.BigInteger;


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
	 * The method isValidTestCase checks whether the test case provided contains
	 * a number of digits within allowed limits.
	 * @param testCase The integer number of test cases to perform.
	 * @return True if the length is within the allowed limits, otherwise false.
	 */
	public static boolean isValidfTestCase( BigInteger testCase )
	{
		String test = testCase.toString();
		boolean res = ( 1 <= test.length()) && ( test.length() <= 1000000 );
		if(!res)
			System.out.println("Error - Number of number of digits must be in the range 1-1000000");

		return res;
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
	 * The method getTestCase allows the user to input, and
	 * return a valid test case.
	 * @return A valid test case.
	 */
	private static BigInteger getTestCase()
	{
		BigInteger testCase;

		System.out.print("Enter test case value > ");
		testCase = getPositiveBigInteger();

		while( !isValidfTestCase(testCase) )
		{
			System.out.print("Enter test case value > ");
			testCase = getPositiveBigInteger();
		}

		return testCase;
	}


	/**
	 * The method isPalindrome returns true if testcase is a palindrome,
	 * otherwise false.
	 * @param testCase A BigInteger to check whether it is a palindrome or not.
	 * @return True if testcase is a palindrome, otherwise false.
	 */
	private static boolean isPalindrome( BigInteger testCase )
	{
		String s = testCase.toString();
		int strLen = s.length();
		for(int i=0, j=strLen-1; i<strLen; i++, j--){
			if(s.charAt(i)!=s.charAt(j))
				return false;
		}
		return true;
	}


	/**
	 * Th method findNextPalindrome finds the next palindrome after n.
	 * @param n A BigInteger.
	 * @return The next palindrome after n.
	 * @throws IndexOutOfBoundsException if a number a palindrome is not found from
	 *		   a number containing less than 1000000 digits.
	 */
	private static BigInteger findNextPalindrome( BigInteger n )
	{
		BigInteger one = new BigInteger("1");
		boolean found = false;
		while(isValidfTestCase(n)) {
			n = n.add(one);
			if(isPalindrome(n)) {
				found = true;
				break;
			}
		}

		if(found)
			return n;
		else
			throw new IndexOutOfBoundsException("Palindrome not found within allowed limits - try using smaller numbers.");
	}


	public static void main(String[] args)
	{
		int numberOfTestCases;

		System.out.println("5 PALIN - The Next Palindrome\n" +
				"\n" +
				"A positive integer is called a palindrome if its representation in the	 \n" +
				"decimal system is the same when read from left to right and from  \n" +
				"right to left. For a given positive integer K of not more \n" +
				"than 1000000 digits, this program will calculate and print\n" +
				"the value of the smallest palindrome larger than K to output. ");


		numberOfTestCases = getNumberOfTestCases();

		BigInteger answers[] = new BigInteger[numberOfTestCases];
		BigInteger testCase;

		for(int i=0; i<numberOfTestCases; i++)
		{
			testCase = getTestCase();
			try {
				answers[i] = findNextPalindrome( testCase );
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println( e.getMessage() );
				i--;
			}
		}

		System.out.println("\n---- Results ----\n");
		for( BigInteger bi : answers )
			System.out.println(bi);
	}
}
