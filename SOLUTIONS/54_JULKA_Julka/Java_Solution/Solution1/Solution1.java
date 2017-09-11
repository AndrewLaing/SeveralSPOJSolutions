/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        30/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Solution1
{
    private static Scanner keyboard = new Scanner( System.in );


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
     * The method isEven return true if the BigInteger n passed to it is even,
     * otherwise false.
     * @param n A BigInteger.
     * @return True if the BigInteger n passed to it is even, otherwise false.
     */
    private static boolean isEven( BigInteger n )
    {
        if( n.mod( new BigInteger("2")).compareTo( new BigInteger("0") ) != 0 )
            return false;
        return true;
    }


    /**
     * The method getMean returns the mean of the total n, dividing it
     * by num and returning the result.
     * @param n A BigInteger total.
     * @param num A BigInteger number used to calculate the mean.
     * @return The mean calculated by dividing n by num.
     */
    private static BigInteger getMean( BigInteger n, BigInteger num )
    {
        return n.divide( num );
    }


    /**
     * The method getMean returns the mean of the total n, dividing it
     * by num and returning the result. Note: this overloads the method
     * above, allowing it to take an integer for num.
     * @param n A BigInteger total.
     * @param num An integer number used to calculate the mean.
     * @return The mean calculated by dividing n by num.
     */
    private static BigInteger getMean( BigInteger n, int num )
    {
        return n.divide( new BigInteger( Integer.toString(num)));
    }


    /**
     * The method canBeCalculated calculates whether Klaudia can actually have
     * difference more apples than Natalia.
     * @param numberOfApples The total number of apples.
     * @param difference The number of apples greater than Natalia's amount
     *                   that Klaudia has.
     * @return True if Klaudia can actually have difference more apples than Natalia,
     *         otherwise false.
     */
    private static boolean canBeCalculated( BigInteger numberOfApples, BigInteger difference )
    {
        if(numberOfApples.compareTo(difference) < 0)
            return false;

        if( isEven( numberOfApples ) != isEven( difference ))
            return false;
        return true;
    }


    /**
     * The method getKlaudiasApples calculates the number of apples held by Klaudia.
     * @param numberOfApples The total number of apples.
     * @param difference The total number more apples that Klaudia has.
     * @param isEvenDifference True if the difference is an even number,
     *                         otherwise false.
     * @return The number of apples held by Klaudia.
     */
    private static BigInteger getKlaudiasApples(BigInteger numberOfApples, BigInteger difference, boolean isEvenDifference )
    {
        if(numberOfApples.compareTo(difference) == 0)
            return numberOfApples;

        BigInteger total = numberOfApples;
        if(isEvenDifference) {
            total = getMean( total, 2 );
            total = total.add( difference.divide( new BigInteger("2")));
        }
        else {
            total = total.add(new BigInteger("1"));
            total = getMean( total, 2 );
            total = total.add( difference.divide( new BigInteger("2")));

        }

        return total;
    }


    /**
     * The method getNataliasApples calculates the number of apples held by Klaudia.
     * @param numberOfApples The total number of apples.
     * @param difference The total number more apples that Klaudia has.
     * @param isEvenDifference True if the difference is an even number,
     *                         otherwise false.
     * @return The number of apples held by Natalia.
     */
    private static BigInteger getNataliasApples(BigInteger numberOfApples, BigInteger difference, boolean isEvenDifference )
    {
        if(numberOfApples.compareTo(difference) == 0)
            return new BigInteger("0");

        BigInteger total = numberOfApples;
        if(isEvenDifference) {
            total = getMean( total, 2 );
            total = total.subtract( difference.divide( new BigInteger("2")));
        }
        else {
            total = total.add(new BigInteger("1"));
            total = getMean( total, 2 );
            total = total.subtract( difference.divide( new BigInteger("2")));
            total = total.subtract( new BigInteger("1") );
        }
        return total;
    }


    
    public static void main(String[] args) {

        System.out.println("54 JULKA - Julka\n" +
                "\n" +
                "Julka surprised her teacher at preschool by solving the following riddle:\n" +
                "\n" +
                "Klaudia and Natalia have 10 apples together, but Klaudia has two apples more than Natalia. \n" +
                "How many apples does each of the girls have?\n" +
                "\n" +
                "Julka said without thinking: \n" +
                "    Klaudia has 6 apples and Natalia 4 apples. \n" +
                "\n" +
                "The teacher tried to check if Julka's answer wasn't accidental and repeated \n" +
                "the riddle every time increasing the numbers. Every time Julka answered correctly. \n" +
                "\n" +
                "The surprised teacher wanted to continue questioning Julka, but with big numbers \n" +
                "she couldn't solve the riddle fast enough herself. This program has been written to\n" +
                "help the teacher by giving her the right answers.\n");


        int numberOfTestCases = 10;
        BigInteger numberOfApples, difference, mean;

        BigInteger answers[] = new BigInteger[numberOfTestCases*2];

        for( int i=0; i<numberOfTestCases*2; i++ )
        {
            System.out.print( "Enter number of apples > " );
            numberOfApples = getPositiveBigInteger();

            System.out.print( "Enter difference > " );
            difference = getPositiveBigInteger();

            if(!canBeCalculated( numberOfApples, difference)) {
                System.out.println("Error - Klaudia cannot have exactly " + difference +
                          " more apples than Natalia!\nRe-enter your data.\n");
                i--;
            }
            else {
                if(isEven(difference)) {
                    answers[i++] = getKlaudiasApples(numberOfApples,difference,true);
                    answers[i] = getNataliasApples(numberOfApples,difference,true);
                }
                else {
                    answers[i++] = getKlaudiasApples(numberOfApples,difference,false);
                    answers[i] = getNataliasApples(numberOfApples,difference,false);
                }
            }

            System.out.println();
        }

        System.out.println("\n---- Results ----");
        int i=1;
        for(BigInteger bi : answers)
        {
            if(i++%2 == 1)
                System.out.println("Klaudia gets " + bi + " apples.");
            else
                System.out.println("Natalia gets " + bi + " apples.\n");
        }

    }

}
