/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		17/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.Scanner;


public class Solution1
{
	public static Scanner keyboard = new Scanner(System.in);


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
					System.out.println("<<< ERROR - invalid input >>>\n");
					System.out.print("Enter a positive integer > ");
					input = keyboard.nextLine();
				}
			}
			catch(Exception e)
			{
				// Display an error message and get new input from the user.
				System.out.println("<<< ERROR - invalid input >>>\n");
				System.out.print("Enter a positive integer > ");
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
	 * The method isPrime returns true if the number n passed to it
	 * is a prime number, otherwise false.
	 * @param n A number to test.
	 * @return True if the number n passed to it is a prime number, otherwise false.
	 */
	public static boolean isPrime( int n )
	{
		if(n<=2)
			return true;

		if(n%2==0)
			return false;

		int high = (int)Math.sqrt(n);

		for(int i=3; i<=high; i+=2) {
			if(n%i==0)
				return false;
		}

		return true;
	}


	/**
	 * The method printPrimesBetween prints the primes between and including n and m
	 * @param n An integer representing the lower limit.
	 * @param m An integer representing the upper limit.
	 */
	public static void printPrimesBetween(int n, int m)
	{
		for(int i=n; i<=m; i++ )
		{
			if(isPrime(i))
				System.out.println(i);
		}
	}


	public static void main(String[] args)
	{
		int numberOfCases;
		int out[] = new int[2];

		System.out.print("Enter number of cases > ");
		numberOfCases = getPositiveInteger();

		String tests[] = new String[numberOfCases];

		for(int cases=0; cases<numberOfCases; cases++)
		{
			System.out.print("Enter the values for n and m > ");
			tests[cases] = new String(keyboard.nextLine());
		}

		System.out.println("\nResults:");

		for(int i=0; i<numberOfCases; i++)
		{
			if( extractTwoNumbers(tests[i], out) )
			{
				if( 1<=out[0] &&
						out[0]<=out[1] &&
						out[1]<=1000000000 &&
						out[1]-out[0]<=100000 )
				{
					printPrimesBetween(out[0], out[1]);
					System.out.println();
				}
				else {
					System.out.println("Invalid entry -'" + tests[i] + "'\n");
				}
			}
			else {
				System.out.println("Invalid entry -'" + tests[i] + "'\n");
			}
		}
	}
}
