/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        26/08/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.*;   /* Used for the Scanner and ArrayList */


public class Solution1 {

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
     * The method isValidEncryptedString validates that a valid length
     * encrypted string has been entered.
     * @param str An encrypted string
     * @param columns The number of columns used in the encryption method.
     * @return True if a valid length encrypted string has been entered,
     *         otherwise false.
     */
    private static boolean isValidEncryptedString(String str, int columns)
    {
        return str.length()%columns == 0;
    }


    /**
     * The method isValidNumberOfColumns validates that a valid number
     * of caolumns has been entered.
     * @param columns The integer number of columns.
     * @return True if a valid number of columns has been entered,
     *         otherwise false.
     */
    private static boolean isValidNumberOfColumns(int columns)
    {
        return ( 2<=columns ) && ( columns<=20 );
    }


    /**
     * The method getNumberOfColumns allows the user to input, and
     * return a valid number of columns.
     * @return A valid number of columns.
     */
    private static int getNumberOfColumns()
    {
        int numberOfColumns;

        System.out.print( "Enter number of columns, or 0 to quit > " );
        numberOfColumns = getPositiveInteger();

        while( numberOfColumns!=0 && !isValidNumberOfColumns(numberOfColumns) )
        {
            System.out.println("Error - Number of columns must be in the range 2-20");
            System.out.print( "Enter number of columns, or 0 to quit > " );
            numberOfColumns = getPositiveInteger();
        }

        return numberOfColumns;
    }


    /**
     * The method firstPass performs the first pass of the decryption algorithm.
     * @param str An encrypted string written in alternating order left-to-right
     * then right-to-left order.
     * @param columns  An integer used in decrypting the string.
     * @return A string prepared for the3 secondPass method.
     */
    public static String firstPass( String str, int columns )
    {
        StringBuilder firstPass = new StringBuilder();

        int switchAt = columns;
        boolean forward = true;

        for( int k=0; k<str.length(); k++ )
        {
            if( k==switchAt) {
                forward = false;
                switchAt += columns*2;
            }

            if(forward) {
                /* Add characters to the StringBuilder in forwards order  */
                firstPass.append(str.charAt(k));
            }
            else {
                /* Add columns characters in reverse order */
                for(int g=1; g<=columns; g++)
                    firstPass.append(str.charAt(k + (columns - g)));

                k += columns-1; /* -1 because of k++ in the for loop header */
                forward = true;
            }
        }

        return firstPass.toString();
    }


    /**
     * The method secondPass performs the second pass of the decryption algorithm.
     * @param str A string which has been processed with the first pass method
     * @param columns An integer used in decrypting the string.
     * @return A decrypted string.
     */
    public static String secondPass( String str, int columns )
    {
        StringBuilder secondPass = new StringBuilder();

        for( int i=0; i<columns; i++ ) {
            for( int j=i; j<str.length(); j+=columns )
                secondPass.append(str.charAt(j));
        }

        return secondPass.toString();
    }


    /**
     * The decypherEncryptedString method runs two passes on an encrypted
     * string to decipher it, and returns the result
     * @param encrypted An encrypted string to decypher
     * @param columns An integer used in decrypting the string.
     * @return A decrypted string.
     */
    public static String decypherEncryptedString( String encrypted, int columns )
    {
        String firstPassResult = firstPass(encrypted, columns);
        return secondPass(firstPassResult, columns);
    }


    public static void main(String[] args)
    {
        List<String> results = new ArrayList<String>();
        String input;
        int columns;

        columns = getNumberOfColumns();

        while( columns > 0 )
        {
            System.out.print("Enter encrypted string > ");
            input = keyboard.nextLine();

            if(isValidEncryptedString(input, columns))
                results.add(decypherEncryptedString(input, columns));
            else
                System.out.println("Error - the string you have entered is invalid.");

            columns = getNumberOfColumns();
        }


        System.out.println("\n---- Results ----");
        for(String s : results )
            System.out.println(s);

    }


}
