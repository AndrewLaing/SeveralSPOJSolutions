/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		23/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.*;	  /* Used for the Scanner and List */

public class Solution1
{
	private static Scanner keyboard = new Scanner(System.in);

	/**
	 * The method getInteger returns an integer input by the user.
	 * @return An integer.
	 */
	private static int getInteger()
	{
		String input;
		boolean isValidInt = false;
		int validatedInteger = 0;

		input = keyboard.nextLine();

		// Validate the user's input. If a valid positive integer has not been entered
		// display an error message and ask for the user to input a valid number
		while(!isValidInt)
		{
			try {
				validatedInteger = Integer.parseInt(input);
				isValidInt = true;
			}
			catch(Exception e)
			{
				// Display an error message and get new input from the user.
				System.out.println("<<< ERROR - Number must be a valid Integer >>>\n");
				System.out.print("Enter a valid integer > ");
				input = keyboard.nextLine();
			}
		}

		return validatedInteger;
	}


	/**
	 * The method isValidNumberOfPackets validates that a valid number
	 * of packets has been entered.
	 * @param numberOfPackets The integer number of packets.
	 * @return True if a valid number of packets has been entered,
	 *		   otherwise false.
	 */
	private static boolean isValidNumberOfPackets( int numberOfPackets )
	{
		return ( 1<=numberOfPackets ) && ( numberOfPackets<=10000 );
	}


	/**
	 * The method isValidNumberOfCandies validates that a valid number
	 * of candies has been entered.
	 * @param candies The integer number of candies.
	 * @return True if a valid number of candies has been entered,
	 *		   otherwise false.
	 */
	private static boolean isValidNumberOfCandies(int candies)
	{
		return ( 1<=candies ) && ( candies<=1000 );
	}


	/**
	 * The method canBeDividedEqually validates that the candies can be equally
	 * divided amongst the kids.
	 * @param totalCandies The total number of candies to share.
	 * @param numberOfPackets The total number of packets of candy.
	 * @return True if the candies can be divided equally,
	 *		   otherwise false.
	 */
	private static boolean canBeDividedEqually( int totalCandies, int numberOfPackets )
	{
		return totalCandies % numberOfPackets ==0;
	}


	/**
	 * The method getSum returns the sum of the numbers stored in
	 * the packets array.
	 * @param packets An int array containing the numbers of candies in each packet.
	 * @return The sum of the numbers stored in the packets array.
	 */
	private static int getSum( int packets[] )
	{
		int total = 0;
		for( int i : packets )
			total += i;

		return total;
	}


	/**
	 * The method getMean calculates the mean of the numbers
	 * stored in the packets array.
	 * @param packets An int array containing the numbers of candies in each packet.
	 * @return The mean of the numbers stored in the packets array.
	 */
	private static int getMean( int packets[] )
	{
		if( packets.length<1 )
			return 0;

		int total = 0;
		for ( int i : packets )
			total += i;

		return total / packets.length;
	}


	/**
	 * The method calculateCandiesToMove calculates the number of
	 * candies which must be moved in order for the kids to have
	 * an equal amount each.
	 * @param packets An int array containing the numbers of candies in each packet.
	 * @return The number of candies which must be moved in order for the kids
	 *		   to have an equal amount each, or -1 if the candies cannot be divided
	 *		   equally amongst the kids.
	 */
	private static int calculateCandiesToMove( int packets[] )
	{
		if( packets.length<=1 )
			return 0;

		int total = 0;
		int mean = getMean( packets );

		for( int i : packets ) {
			if( i>mean )
				total += i-mean;
		}

		return total;
	}


	/**
	 * The method getNumberOfPackets allows the user to input, and
	 * return a valid number of packets.
	 * @return A valid number of packets.
	 */
	private static int getNumberOfPackets()
	{
		int numberOfPackets;

		System.out.print( "Enter number of packets, or -1 to quit > " );
		numberOfPackets = getInteger();

		while( numberOfPackets!=-1 && !isValidNumberOfPackets(numberOfPackets) )
		{
			System.out.println("Error - Number of packets must be in the range 1-10000");
			System.out.print( "Enter number of packets, or -1 to quit > " );
			numberOfPackets = getInteger();
		}

		return numberOfPackets;
	}


	/**
	 * The method getNumberOfCandies allows the user to input, and
	 * return a valid number of candies.
	 * @return A valid number of candies.
	 */
	private static int getNumberOfCandies()
	{
		int numberOfCandies;

		System.out.print( "Enter number of candies in packet > " );
		numberOfCandies = getInteger();

		while(!isValidNumberOfCandies( numberOfCandies ))
		{
			System.out.print("Error - Number of candies must be in the range 1-1000");
			System.out.println( "Enter number of candies in packet > " );
			numberOfCandies = getInteger();
		}

		return numberOfCandies;
	}


	public static void main(String[] args)
	{
		List<Integer> results = new ArrayList<Integer>();
		int numberOfPackets;
		int packet;

		System.out.println("2123 CANDY - Candy I\n" +
				"\n" +
				"Jennifer is a teacher in the first year of a primary school. \n" +
				"She has gone for a trip with her class today. She has taken a packet of candies for each child. \n" +
				"Unfortunately, the sizes of the packets are not the same.\n" +
				"\n" +
				"Jennifer is afraid that each child will want to have the biggest packet of candies and this will \n" +
				"lead to quarrels or even fights among children. She wants to avoid this. Therefore, she has decided \n" +
				"to open all the packets, count the candies in each packet and move some candies from bigger packets \n" +
				"to smaller ones so that each packet will contain the same number of candies. \n" +
				"The question is how many candies she has to move.\n\n" +
				"In this program you first enter a number of packets ( or -1 to quit)\n" +
				"then the number of candies in each packet. After you have finished\n" +
				"inputting the data, the results will be displayed.\n");


		/* Enter number of packets to follow */
		numberOfPackets = getNumberOfPackets();

		while(numberOfPackets!=-1)
		{
			/* Enter candies in each packet */
			int packets[] = new int[numberOfPackets];
			for(packet=0; packet<numberOfPackets; packet++) {
				packets[packet] = getNumberOfCandies();
			}
			/* Calculate candies to move */
			if( !canBeDividedEqually(getSum(packets), numberOfPackets) )
				results.add(-1);
			else
				results.add(calculateCandiesToMove(packets));

			/* Enter number of packets to follow */
			numberOfPackets = getNumberOfPackets();
		}

		/* Display results */
		System.out.println("\n---- Results ---");
		for(int result : results)
			System.out.println(result);

	}
}
