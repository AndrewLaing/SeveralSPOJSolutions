/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		10/09/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.*; /* For Scanner and List */

public class Solution1
{
	private static Scanner keyboard = new Scanner(System.in);

	/**
	 * The method getPositiveFloat returns a positive float input by the user.
	 * @return A positive float.
	 */
	public static float getPositiveFloat()
	{
		String input;
		boolean isValidFloat = false;
		float positiveFloat = 0;

		input = keyboard.nextLine();

		// Validate the user's input. If a valid positive integer has not been entered
		// display an error message and ask for the user to input a valid number
		while(!isValidFloat)
		{
			try {
				positiveFloat = Float.parseFloat(input);

				// If the user has entered a valid positive integer the while loop can be exited
				if(positiveFloat>=0)
					isValidFloat = true;
				else
				{
					// Display an error message and get new input from the user.
					System.out.println("<<< ERROR - Number must be a positive decimal number >>>\n");
					System.out.print("Enter a positive decimal number > ");
					input = keyboard.nextLine();
				}
			}
			catch(Exception e)
			{
				// Display an error message and get new input from the user.
				System.out.println("<<< ERROR - Number must be a positive decimal number >>>\n");
				System.out.print("Enter a positive decimal number > ");
				input = keyboard.nextLine();
			}
		}

		return positiveFloat;
	}

	/**
	 * The method isValidTestCaseValue checks whether the test case value provided
	 * is within allowed limits.
	 * @param testCaseValue The value of the test case.
	 * @return True if the value is within the allowed limits, otherwise false.
	 */
	public static boolean isValidTestCaseValue( float testCaseValue)
	{
		boolean result = ( 0.0 <= testCaseValue ) && ( testCaseValue <= 5.20 );
		if(!result)
			System.out.print("Error - Test case value must be in the range 0.01 to 5.20");
		return result;
	}

	/**
	 * The method getTestCaseValue allows the user to input, and
	 * return a test case value.
	 * @return A test case value.
	 */
	private static float getTestCaseValue()
	{
		float testCaseValue;

		System.out.print( "Enter test case value > " );
		testCaseValue = getPositiveFloat();

		while(!isValidTestCaseValue( testCaseValue))
		{
			System.out.print( "Enter test case value > " );
			testCaseValue = getPositiveFloat();
		}

		return testCaseValue;
	}


	private static int getNumberOfCards( float hangover )
	{
		float total = 0;
		for(int i=2; i<100000; i++) {
			total += (float)1.0/i;
			if(total>=hangover)
				return i-1;
		}

		return 0;
	}


	public static void main(String[] args)
	{
		System.out.println("902 - Hangover\n");
		System.out.println("How far can you make a stack of cards overhang a table? \n" +
				"If you have one card, you can create a maximum overhang \n" +
				"of half a card length. (We're assuming that the cards \n" +
				"must be perpendicular to the table.)\n" +
				" \n" +
				"With two cards you can make the top card overhang the \n" +
				"bottom one by half a card length, and the bottom one \n" +
				"overhang the table by a third of a card length, for a \n" +
				"total maximum overhang of 1/2 + 1/3 = 5/6 card lengths. \n" +
				"\n" +
				"In general you can make n cards overhang by \n" +
				"1/2 + 1/3 + 1/4 + ... + 1/(n + 1) card lengths,\n" +
				"where the top card overhangs the second by 1/2, the \n" +
				"second overhangs the third by 1/3, the third overhangs \n" +
				"the fourth by 1/4, etc., and the bottom card overhangs \n" +
				"the table by 1/(n + 1). \n" +
				"\n" +
				"This is illustrated in the figure below.\n" +
				"\n" +
				"						 ================== \n" +
				"				================== \n" +
				"		   ================== \n" +
				"	   ================== \n" +
				"	================== \n" +
				"000000000000000000\n" +
				"000000000000000000\n" +
				"000000000000000000\n" +
				"000000000000000000\n\n" +
				"This program, given a decimal number representing the\n" +
				"overhang, calculates the number of cards needed to\nproduce it.\n\n");


		List<Integer> results = new ArrayList<Integer>();
		float testCaseValue = getTestCaseValue();

		while( testCaseValue >= 0.01 )
		{
			results.add(getNumberOfCards(testCaseValue));
			testCaseValue = getTestCaseValue();
		}

		System.out.println("\n---- Results ----");
		for(int i : results)
			System.out.println(i);
	}
}
