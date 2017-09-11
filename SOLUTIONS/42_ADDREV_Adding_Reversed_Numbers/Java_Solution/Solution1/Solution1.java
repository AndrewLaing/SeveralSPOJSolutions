import java.util.Scanner;


/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        17/08/2017.
 * Description: SPOJ Exercise - see README.md
 * Todo:        Update the method description comments
 */


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
    public static boolean extractTwoReversedNumbers(String in, int out[]) {
        return extractReversedNumbers(in, out, 2);
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
    public static boolean extractReversedNumbers(String in, int out[], int n)
    {
        String s[] = in.split(" ");

        if(s.length != n)
            return false;

        try {
            for(int i = 0 ; i < n ; i++)
                out[i] = Integer.parseInt( reverseString( s[i]) );
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }


    /**
     * The method reverseString takes a string and returns a reversed
     * version of it
     * @param s The string to reverse.
     * @return The reversed version of the string.
     */
    public static String reverseString(String s)
    {
        return new StringBuffer(s).reverse().toString();
    }


    /**
     * The method getReversedSum gets the sum of the two integers contained
     * in the out array, converts it to a string, reverses the string, and
     * returns the result converted back to an integer.
     * @param out An array containing two integers
     * @return The integer result of adding and reversing two numbers
     */
    public static int getReversedSum(int out[])
    {
        int sum = out[0] + out[1];
        String temp = Integer.toString(sum);
        return Integer.parseInt( reverseString( temp ) );
    }


    public static void main(String[] args)
    {
        String input;
        int numberOfCases;
        int out[] = new int[2];

        System.out.print("Enter number of cases > ");
        numberOfCases = getPositiveInteger();

        int results[] = new int[numberOfCases];

        for(int cases=0; cases<numberOfCases; cases++)
        {
            System.out.print("Enter a line > ");
            input = keyboard.nextLine();

            if(extractTwoReversedNumbers(input, out))
            {
                results[cases] = getReversedSum(out);
            }
            else {
                System.out.println("Error - invalid input!");
                results[cases] = 0;
            }
        }

        System.out.println("\nResults:");

        for(int i=0; i<numberOfCases; i++)
            System.out.println(results[i]);
    }
}
