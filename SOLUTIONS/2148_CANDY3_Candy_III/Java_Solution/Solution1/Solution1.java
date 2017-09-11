/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        01/09/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.Scanner;


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
     * The method isValidNumberOfChildren validates that a valid number
     * of children has been entered.
     * @param numberOfChildren The number of children.
     * @return True if a valid number of children has been entered,
     *         otherwise false.
     */
    private static boolean isValidNumberOfChildren( int numberOfChildren )
    {
        boolean result = ( 1<=numberOfChildren) && ( numberOfChildren<=10000 );

        if(!result)
            System.out.println("Error - Number of children must be in the range 1-10000");

        return result;
    }


    /**
     * The method isValidNumberOfCandies validates that a valid number
     * of candies has been entered.
     * @param candies The integer number of candies.
     * @return True if a valid number of candies has been entered,
     *         otherwise false.
     */
    private static boolean isValidNumberOfCandies(int candies)
    {
        boolean result = ( 0<=candies ) && ( candies<=1000 );

        if(!result)
            System.out.println("Error - Number of candies must be in the range 0-1000");

        return result;
    }


    /**
     * The method isValidNumberOfTestCases checks whether the number of test cases
     * to perform is within allowed limits.
     * @param numberOfTestCases The integer number of test cases to perform.
     * @return True if the value is within the allowed limits, otherwise false.
     */
    public static boolean isValidNumberOfTestCases(int numberOfTestCases)
    {
        boolean result = ( 1 <= numberOfTestCases ) && ( numberOfTestCases <= 10 );
        if(!result)
            System.out.println("Error - Number of test cases must be in the range 1 to 10");
        return result;
    }


    /**
     * The method canBeDividedEqually validates that the candies can be equally
     * divided amongst the kids.
     * @param totalCandies The total number of candies to share.
     * @param numberOfChildren The total number of children.
     * @return True if the candies can be divided equally,
     *         otherwise false.
     */
    private static boolean canBeDividedEqually( int totalCandies, int numberOfChildren )
    {
        return totalCandies % numberOfChildren == 0;
    }


    /**
     * The method getNumberOfChildren allows the user to input, and
     * return a valid number of children.
     * @return A valid number of children.
     */
    private static int getNumberOfChildren()
    {
        int numberOfChildren;

        System.out.print( "\nEnter number of children > " );
        numberOfChildren = getPositiveInteger();

        while( !isValidNumberOfChildren( numberOfChildren ) )
        {
            System.out.print( "Enter number of children > " );
            numberOfChildren = getPositiveInteger();
        }

        return numberOfChildren;
    }


    /**
     * The method getNumberOfCandies allows the user to input, and
     * return a valid number of candies.
     * @return A valid number of candies.
     */
    private static int getNumberOfCandies()
    {
        int numberOfCandies;

        System.out.print( "Enter number of candies in child's packet > " );
        numberOfCandies = getPositiveInteger();

        while(!isValidNumberOfCandies( numberOfCandies ))
        {
            System.out.print( "Enter number of candies in child's packet > " );
            numberOfCandies = getPositiveInteger();
        }

        return numberOfCandies;
    }


    /**
     * The method getNumberOfTestCases allows the user to input, and
     * return the number of test cases to perform.
     * @return The number of test cases to perform.
     */
    private static int getNumberOfTestCases()
    {
        int numberOfTestCases;

        System.out.print( "Enter number of test cases > " );
        numberOfTestCases = getPositiveInteger();

        while(!isValidNumberOfTestCases( numberOfTestCases ))
        {
            System.out.print( "Enter number of test cases > " );
            numberOfTestCases= getPositiveInteger();
        }

        return numberOfTestCases;
    }


    public static void main(String[] args)
    {
        System.out.println("2148 CANDY3 - Candy III\n" +
                "\n" +
                "A class went on a school trip. And, as usual, all N kids have their backpacks\n" +
                "stuffed full of candy. Quarrels soon started all over the place, as some of the kids\n" +
                "had more candies than others.\n" +
                "\n" +
                "The teacher realized that he has to step in: \n" +
                "  \"Everybody, listen! Put all the candies you have on this table here!\"\n" +
                "\n" +
                "Soon, there was quite a large heap of candies on the teacher's table. \n" +
                "\n" +
                "  \"Now, I will divide the candies into N equal heaps and everybody will get one of them.\"\n" +
                "\n" +
                "announced the teacher.\n" +
                "\n" +
                "  \"Wait, is this really possible?\" wondered some of the smarter kids.\n" +
                "\n" +
                "In this program you first enter the number of test cases which will follow,\n" +
                "the number of children in each test case, then the number of candies that\n" +
                "each child has brought with them.\n" +
                "The program will then find out whether the teacher can divide the candies\n" +
                "into N exactly equal heaps. (For the purpose of this task, all candies are\n" +
                "of the same type.) The answers will be shown once you have finished inputting\n" +
                "the data.\n\n");


        int numberOfTestCases;
        int numberOfChildren;
        int packet;

        numberOfTestCases = getNumberOfTestCases();
        String answers[] = new String[numberOfTestCases];

        for( int i=0; i<numberOfTestCases; i++ )
        {
            /* Enter number of children to count candies for  */
            numberOfChildren = getNumberOfChildren();

            /* Enter candies in each packet */
            int totalCandies = 0;
            for(packet=0; packet<numberOfChildren; packet++) {
                totalCandies += getNumberOfCandies();
            }
            /* Calculate whether candies can be divided equally */
            if( canBeDividedEqually( totalCandies, numberOfChildren) )
                answers[i] = "YES" ;
            else
                answers[i] = "NO" ;
        }

        System.out.println("\n---- Results ----");
        for(String s : answers)
            System.out.println(s);
    }
}
