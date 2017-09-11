/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		22/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.*;	  /* Used for the Scanner and ArrayList*/

public class Solution1
{
	private static Scanner keyboard = new Scanner(System.in);


	/**
	 * The extractThreeNumbers method takes a String of three numbers separated
	 * by a space, extracts the numbers, converts them to ints, and places
	 * them into the out array.
	 * @param in A string containing three numbers separated by spaces.
	 * @param out An int array to store the extracted numbers in.
	 * @return True if the operation was successful, otherwise false.
	 */
	public static boolean extractThreeNumbers(String in, int out[]) {
		return extractNumbers(in, out, 3);
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
	 * The method getSum adds together the contents of the int array
	 * passed to it and returns their sum.
	 * @param out An integer array
	 * @return The sum of the contents of the integer array.
	 */
	public static int getSum(int out[])
	{
		int sum = 0;
		for(int i : out)
			sum += i;

		return sum;
	}


	/**
	 * The method isAP returns true if the number sequence contained in the
	 * int array out is an Arithmetic Progression, otherwise false.
	 * @param out An integer array containing a number sequence.
	 * @return True if the number sequence contained in the int array out
	 *		   is an Arithmetic Progression, otherwise false
	 */
	public static boolean isAP( int out[] )
	{
		return ( out[2]-out[1] ) == ( out[1] - out[0] );

	}


	/**
	 * The method isGP returns true if the number sequence contained in the
	 * int array out is a Geometric Progression, otherwise false.
	 * @param out An integer array containing a number sequence.
	 * @return True if the number sequence contained in the int array out
	 *		   is a Geometric Progression, otherwise false.
	 */
	public static boolean isGP( int out[] )
	{
		return ( out[2]/out[1] ) == ( out[1]/out[0] );

	}


	/**
	 * The method calculateAPValue returns the next value in the
	 * Arithmetic Progression (AP) sequence contained in the int array out.
	 * @param out An integer array containing an AP number sequence.
	 * @return The next integer value in the AP number sequence.
	 */
	public static int calculateAPValue(	 int out[] )
	{
		return out[2] + ( out[1] - out[0] );
	}


	/**
	 * The method calculateGPValue returns the next value in the
	 * Geometric Progression (GP) sequence contained in the int array out.
	 * @param out An integer array containing an GP number sequence.
	 * @return The next integer value in the GP number sequence.
	 */
	public static int calculateGPValue(	 int out[] )
	{
		return out[2] * ( out[2] / out[1] );
	}



	public static void main(String[] args)
	{
		List<String> results = new ArrayList<String>();
		String input;
		int out[] = new int[3];

		System.out.println("7974 - ACPC10A What’s Next\n");

		System.out.println("According to Wikipedia, an arithmetic progression (AP) is a sequence of numbers \n" +
				"such that the difference of any two successive members of the sequence is a constant. \n" +
				"For instance, the sequence 3, 5, 7, 9, 11, 13, . . . is an arithmetic progression \n" +
				"with common difference 2. \n" +
				"\n" +
				"In this program, we will limit ourselves to arithmetic progression whose common \n" +
				"difference is a non-zero integer.\n" +
				"\n" +
				"On the other hand, a geometric progression (GP) is a sequence of numbers where \n" +
				"each term after the first is found by multiplying the previous one by a fixed non-zero \n" +
				"number called the common ratio. For example, the sequence 2, 6, 18, 54, . . . \n" +
				"is a geometric progression with common ratio 3. \n" +
				"\n" +
				"In this program, we will limit ourselves to geometric progression whose common \n" +
				"ratio is a non-zero integer. Given three successive members of a sequence, this \n" +
				"program will determine the type of the progression and the next member of the sequence.\n");

		System.out.print("Enter 3 number sequence or 0 0 0 to quit > ");
		input = keyboard.nextLine();

		while(!extractThreeNumbers(input, out))
		{
			System.out.println("Error invalid input '" + input + "'");
			System.out.print("Enter 3 number sequence > ");
			input = keyboard.nextLine();
		}

		while( getSum(out) != 0 )
		{
			/* Add results to the results ArrayList*/
			if(isAP(out))
				results.add("AP: " + calculateAPValue(out));
			else if(isGP(out))
				results.add("GP: " + calculateGPValue(out));
			else
				System.out.println("Error invalid number sequence '" + input + "'");

			/* Enter another sequence */
			System.out.print("Enter 3 number sequence > ");
			input = keyboard.nextLine();

			/* Convert string to 3 integers, or deal with bad input */
			while(!extractThreeNumbers(input, out))
			{
				System.out.println("Error invalid input '" + input + "'");
				System.out.print("Enter 3 number sequence > ");
				input = keyboard.nextLine();
			}
		}

		/* Display the result strings added to the results ArrayList */
		System.out.println("\n---- Results ---- ");
		for(String s : results)
		{
			System.out.println(s);
		}
	}
}
