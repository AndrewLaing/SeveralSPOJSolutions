/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		21/08/2017.
 * Description: SPOJ Exercise - see README.md
 */


import java.util.*;				// Used for Scanner, List and ArrayList

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
	 * The method calculateNumberOfSquares calculates recursively, and returns
	 * the solution to Feynman's problem.
	 * @param n The number of squares on the side of the grid.
	 * @return The total number of squares in the grid.
	 */
	public static int calculateNumberOfSquares(int n)
	{
		int total = n * n;
		if(n > 0)
			total += calculateNumberOfSquares( n-1 );
		return total;
	}


	/**
	 * The method isValidSideLength checks whether the side length entered
	 * is within allowed limits.
	 * @param sideLength The integer value for the length of the squares side.
	 * @return True if the value is within the allowed limits, otherwise false.
	 */
	public static boolean isValidSideLength(int sideLength)
	{
		return ( 0 <= sideLength ) && ( sideLength <= 100 );
	}


	public static void main(String[] args)
	{
		List<Integer> results = new ArrayList<Integer>();
		int length;

		System.out.println("Richard Phillips Feynman was a well known American physicist and a recipient \n" +
				"of the Nobel Prize in Physics. He worked in theoretical physics and also pioneered \n" +
				"the field of quantum computing. He visited South America for ten months, giving \n" +
				"lectures and enjoying life in the tropics. He is also known for his books \n" +
				"\"Surely You're Joking, Mr. Feynman!\" and \"What Do You Care What Other People Think?\", \n" +
				"which include some of his adventures below the equator.\n" +
				"\n" +
				"His life-long addiction was solving and making puzzles, locks, and cyphers. \n" +
				"Recently, an old farmer in South America, who was a host to the young physicist \n" +
				"in 1949, found some papers and notes that is believed to have belonged to Feynman. \n" +
				"Among notes about mesons and electromagnetism, there was a napkin where he wrote \n" +
				"a simple puzzle: \"how many different squares are there in a grid of N x N squares?\".\n");

		System.out.println("This program provides a solution to Feynman's problem\n" +
				"On each line that follows, enter the number of squares in length of the grid\n" +
				"(1 <= n <= 100), or 0 to quit.\n");

		System.out.print("Enter number of squares > ");
		length = getPositiveInteger();

		while(length>0)
		{
			if(isValidSideLength( length )) {
				results.add(calculateNumberOfSquares( length ) );
			}
			else {
				System.out.println("Error - number of squares must be in the range 1 - 100");
			}
			System.out.print("Enter number of squares > ");
			length = getPositiveInteger();
		}

		/* Display the results stored in the ArrayList */
		System.out.println("\n---- Results ----");
		for(Integer result : results) {
			System.out.println(result);
		}
	}

}
