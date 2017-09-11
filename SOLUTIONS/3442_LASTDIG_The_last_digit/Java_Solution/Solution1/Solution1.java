/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		27/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.Scanner;	/* Used for the Scanner */

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
	 * The extractTwoNumbers method takes a String of two numbers separated
	 * by a space, extracts the numbers, converts them to ints, and places
	 * them into the out array.
	 * @param in A string containing two numbers separated by a space.
	 * @param out An int array to store the extracted numbers in.
	 * @return True if the operation was successful, otherwise false.
	 */
	public static boolean extractTwoNumbers(String in, int out[]) {
		return extractNumbers(in, out, 2);
	}


	/**
	 * The extractNumbers method takes a String of n numbers separated
	 * by a space, extracts the numbers, converts them to ints, and places
	 * them into the out array.
	 * @param in A string containing two numbers separated by a space.
	 * @param out An int array to store the extracted numbers in.
	 * @param n The number of numbers to extract
	 * @return True if the operation was successful, otherwise false.
	 */
	public static boolean extractNumbers(String in, int out[], int n)
	{
		String s[] = in.split(" ");

		if(s.length != n)
			return false;

		try {
			for(int i = 0 ; i < n ; i++)
				out[i] = Integer.parseInt( s[i] );
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
		boolean result = ( 1 <= numberOfTestCases ) && ( numberOfTestCases <= 30 );

		if(!result)
			System.out.println("Error - number of test cases must be in the range 1 to 30.");

		return result;
	}


	/**
	 * The method isValidBase checks whether the base supplied is within allowed limits.
	 * @param base The integer number representing the base.
	 * @return True if the value is within the allowed limits, otherwise false.
	 */
	public static boolean isValidBase(int base)
	{
		boolean result = ( 0 <= base ) && ( base <= 20 );

		if(!result)
			System.out.println("Error - base must be in the range 0 to 20.");

		return result;
	}


	/**
	 * The method isValidIndex checks whether the index supplied is within allowed limits.
	 * @param idx integer number representing the index.
	 * @return True if the value is within the allowed limits, otherwise false.
	 */
	public static boolean isValidIndex(int idx)
	{
		boolean result = ( 0 <= idx ) && ( idx <= 2147483000 );

		if(!result)
			System.out.println("Error - index must be in the range 0 to 2147483000.");

		return result;
	}



	/**
	 * The method getNumberOfTestCases allows the user to input, and
	 * return a valid number of test cases.
	 * @return A valid number of test cases.
	 */
	private static int getNumberOfTestCases()
	{
		int numberOfTestCases;

		System.out.print( "Enter number of test cases > " );
		numberOfTestCases = getPositiveInteger();

		while(!isValidNumberOfTestCases( numberOfTestCases ))
		{
			System.out.println( "Enter number of test cases > " );
			numberOfTestCases= getPositiveInteger();
		}

		return numberOfTestCases;
	}


	/**
	 * The method isValidInput checks that the user has supplied valid input
	 * for the base and index.
	 * @param out An int array containing a base and index.
	 * @return True if the user has supplied valid input for the base and index,
	 *		   otherwise false.
	 */
	private static boolean isValidInput( int out[])
	{
		return ( isValidBase(out[0]) && isValidIndex(out[1]) );
	}


	/**
	 * The method getBaseAndIndex gets the user to input the base and index
	 * on a line separated by a space, splits the line and stores them into
	 * the out array.
	 * @param out An array to store the base an d index.
	 * @return True if the operation performed correctly, otherwise false.
	 */
	private static boolean getBaseAndIndex( int out[])
	{
		System.out.print( "Enter base and index separated by a space > " );
		String input = keyboard.nextLine();

		while( !extractTwoNumbers(input, out))
		{
			System.out.println("Error - invalid input.");
			System.out.print( "Enter base and index separated by a space > " );
			input = keyboard.nextLine();
		}

		if (!isValidInput( out ))
			return false;

		return true;
	}


	/**
	 * The method getLastDigitOfPotency calculates the last digit for the
	 * potency of the base at index idx. Note this digit can be found simply
	 * due to the fact that the last digit of each bases potency runs in a
	 * recurring sequence of four numbers, excluding position 0
	 * (example base 2 -> 2 4 8 16 32 64 128 516 ...	2 4 8 6 2 4 8 6 ... )
	 * @param base A number representing the base.
	 * @param idx A number representing the index
	 * @return The last digit for the potency of the base at index idx.
	 */
	private static int getLastDigitOfPotency(int base, int idx)
	{
		int result;

		if(base==0) return 0;
		if(idx==0) return 1;

		int power = idx%4;
		if(power == 0) power=4;

		int idxPotency = (int)Math.pow(base, power);

		if(idxPotency>10) {
			int temp = idxPotency;
			idxPotency/=10;				   /* Clear off last digit*/
			idxPotency*=10;
			result = temp - idxPotency;	   /* Get last digit */
		}
		else
			result = idxPotency;

		return result;
	}


	public static void main(String[] args)
	{
		System.out.println("Nestor needs to deliver a solution to his math problem tomorrow.\n" +
				"His maths teacher gave him two numbers a and b.\n" +
				"The problem consists in finding the last digit of the potency of base a and index b. \n" +
				"This program is designed to help Nestor with his problem, finding the last digit of ab.\n");

		int numberOfTestCases = getNumberOfTestCases();

		int answers[] = new int[numberOfTestCases];
		int out[] = new int[2];

		for(int i=0; i<numberOfTestCases; i++)
		{
			while(!getBaseAndIndex(out)) /* If input was invalid try again.*/
				;

			/* process and add to answers here */
			answers[i] = getLastDigitOfPotency(out[0], out[1]);
		}

		System.out.println("\n---- Results ----");
		for( int i : answers)
			System.out.println(i);

	}
}
