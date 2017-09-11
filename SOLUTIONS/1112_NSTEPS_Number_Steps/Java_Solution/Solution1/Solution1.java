/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		21/08/2017.
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
		return ( 1 <= numberOfTestCases ) && ( numberOfTestCases <= 100 );
	}


	/**
	 * The method isValidCoordinate checks whether the coordinate entered
	 * is within allowed limits.
	 * @param coordinate The integer value coordinate.
	 * @return True if the value is within the allowed limits, otherwise false.
	 */
	public static boolean isValidCoordinate(int coordinate)
	{
		return ( 1 <= coordinate ) && ( coordinate <= 10000 );
	}


	/**
	 * The method getNumberStep calculates and returns the positive integer stored
	 * at coordinate (x, y). If no number is stored there it returns -1.
	 * @param x The x coordinate of the location to examine.
	 * @param y The y coordinate of the location to examine.
	 * @return A positive integer stored at coordinate (x, y).
	 *		   If no number is stored there the method returns -1.
	 */
	public static int getNumberStep(int x, int y)
	{
		if(y<0 || x < 0)
			return -1;

		if( y!=x && y+2!=x )
			return -1;

		if(x<2)
			return x;
		else if(x == 2 || x%2==0)
			return x+y;
		else
			return x+y-1;
	}


	public static void main(String[] args) {
		int numberOfTestCases;
		int out[] = new int[2];

		System.out.println("This program reads the coordinates of a point (x y), \n" +
				"and writes the number (if any) that has been written at that point. \n" +
				"(x y) coordinates in the input are in the range 0...10000.\n");


		/* Input the number of test cases which will be entered */
		System.out.print("Enter number of test cases to perform > ");
		numberOfTestCases = getPositiveInteger();

		while(!isValidNumberOfTestCases(numberOfTestCases)) {
			System.out.println("Error - number of test cases must be between 1 and 100.");
			System.out.print("Enter a valid number of test cases > ");
			numberOfTestCases = getPositiveInteger();
		}

		/* Input the values for the test cases, calculate the value stored at the
		 * coordinates, and add the result to the answers array */

		String tests[] = new String[numberOfTestCases];
		int result;

		System.out.println("Coordinates should be entered as two numbers separated by a space.");

		for(int cases=0; cases<numberOfTestCases; cases++)
		{
			System.out.print("Enter coordinates > ");
			tests[cases] = keyboard.nextLine();
		}

		/* Calculate and display results */
		System.out.println("\n---- Results ----");

		for(int i=0; i<numberOfTestCases; i++)
		{
			if( extractTwoNumbers(tests[i], out) )
			{
				if( isValidCoordinate(out[0]) && isValidCoordinate(out[1]) ) {
					result = getNumberStep(out[0], out[1]);
					if(result == -1)
						System.out.println("No Number");
					else
						System.out.println(result);
				}
				else
					System.out.println("Invalid entry -'" + tests[i] + "'\n");
			}
			else {
				System.out.println("Invalid entry -'" + tests[i] + "'\n");
			}
		}
	}

}
