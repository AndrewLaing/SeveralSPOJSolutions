/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        14/09/2017.
 * Description:
 */

import java.util.Scanner;
import java.util.StringTokenizer;

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
     * The method isValidInteger returns true if String s can be converted
     * to a valid integer, otherwise false.
     * @param s A string to test whether it contains a valid integer or not.
     * @return True if String s can be converted to a valid integer, otherwise false.
     */
    private static boolean isValidInteger( String s )
    {
         try {
              Integer.parseInt(s);
         }
         catch(Exception e) {
             return false;
         }

         return true;
    }


    /**
     * The method isValidOperator returns true if String s can be converted
     * to a valid operator, otherwise false.
     * @param s A string to test whether it contains a valid operator or not.
     * @return True if String s can be converted to a valid operator, otherwise false.
     */
    private static boolean isValidOperator( String s )
    {
        boolean result;

        switch(s.charAt(0))
        {
            case '+': case '-': case '*': case '/':
                result = true;
                break;
            default:
                result = false;
                break;
        }

        return result;
    }


    /**
     * The method containsMachula returns true if the String s contains
     * the substring 'machula', otherwise false.
     * @param s A string to test whether it contains 'machula' or not.
     * @return True if the String s contains the substring 'machula', otherwise false.
     */
    private static boolean containsMachula( String s )
    {
        return s.contains("machula");
    }


    private static int replaceBlottedAddition(  int a, int b, int c, int machulaIdx )
    {
        int result;

        switch(machulaIdx) {
            case 0:
                result = c - b;
                break;
            case 2:
                result = c - a;
                break;
            case 4:
                result = a + b;
                break;
            default:
                System.out.println("Error in replaceBlottedAddition - illegal index.");
                result = -1;
                break;
        }

        return result;
    }


    private static int replaceBlottedSubtraction(  int a, int b, int c, int machulaIdx )
    {
        int result;

        switch(machulaIdx) {
            case 0:
                result = b + c;
                break;
            case 2:
                result = a - c;
                break;
            case 4:
                result = a - b;
                break;
            default:
                System.out.println("Error in replaceBlottedSubtraction - illegal index.");
                result = -1;
                break;
        }

        return result;
    }


    private static int replaceBlottedMultiplication(  int a, int b, int c, int machulaIdx )
    {
        int result;

        switch(machulaIdx) {
            case 0:
                result = c / b;
                break;
            case 2:
                result = c / a;
                break;
            case 4:
                result = a * b;
                break;
            default:
                System.out.println("Error in replaceBlottedMultiplication - illegal index.");
                result = -1;
                break;
        }

        return result;
    }


    private static int replaceBlottedDivision(  int a, int b, int c, int machulaIdx )
    {
        int result;

        switch(machulaIdx) {
            case 0:
                result = c * b;
                break;
            case 2:
                result = a / c;
                break;
            case 4:
                result = a / b;
                break;
            default:
                System.out.println("Error in replaceBlottedDivision - illegal index.");
                result = -1;
                break;
        }

        return result;
    }


    private static char replaceBlottedOperator(  int a, int b, int c )
    {
        char result;

        if( a + b == c )
            result = '+';
        else if( a - b == c )
            result = '-';
        else if( a * b == c )
            result = '*';
        else if( a / b == c )
            result = '/';
        else {
            System.out.println("Error - unable to calculate the missing operator");
            result = '?';
        }

        return result;
    }


    private static String replaceBlotted( int a, int b, int c, char theOperator, int machulaIdx )
    {
        String result = "";
        int unblotted = -1;

        if(machulaIdx != 1 && machulaIdx != -1)
        {
            switch(theOperator) {
                case '+':
                    unblotted = replaceBlottedAddition( a, b, c, machulaIdx );
                    break;
                case '-':
                    unblotted = replaceBlottedSubtraction( a, b, c, machulaIdx );
                    break;
                case '*':
                    unblotted = replaceBlottedMultiplication( a, b, c, machulaIdx );
                    break;
                case '/':
                    unblotted = replaceBlottedDivision( a, b, c, machulaIdx );
                    break;
            }
        }
        else {
            theOperator = replaceBlottedOperator( a, b, c );
        }


        switch(machulaIdx) {
            case 0:
                a = unblotted;
                break;
            case 1:
                break;
            case 2:
                b = unblotted;
                break;
            case 4:
                c = unblotted;
                break;
            default:
                break;
        }

        result = Integer.toString(a) + " " + theOperator + " " + Integer.toString(b) + " = " + Integer.toString(c);

        return result;
    }


    private static String processString( String toCorrect )
    {
        String result = "";
        String temp;
        int a=0, b=0, c=0;      /* eg a + b = c */
        char theOperator = '+';
        int machulaIdx = -1;

        String delim = " ";
        StringTokenizer st = new StringTokenizer(toCorrect, delim);

        int count = 0;
        while (st.hasMoreElements()) {
            temp = st.nextElement().toString();
            if(containsMachula(temp)) {
                machulaIdx = count;
            }
            else if(isValidInteger(temp)) {
                if(count == 0)
                    a = Integer.parseInt(temp);
                else if(count == 2)
                    b = Integer.parseInt(temp);
                else if(count == 4)
                    c = Integer.parseInt(temp);
            }
            else if(isValidOperator(temp)) {
                theOperator = temp.charAt(0);
            }
            count++;
        }

        result = replaceBlotted( a, b, c, theOperator, machulaIdx );

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
        boolean res = ( 1 <= numberOfTestCases ) && ( numberOfTestCases <= 100 );
        if(!res)
            System.out.println("Error - Number of test cases must be in the range 1-100");

        return res;
    }


    /**
     * The method getNumberOfTestCases allows the user to input, and
     * return a valid number of test cases.
     * @return A valid number of test cases.
     */
    private static int getNumberOfTestCases()
    {
        int numberOfTestCases;

        System.out.print("\nEnter number of test cases > ");
        numberOfTestCases = getPositiveInteger();

        while( !isValidNumberOfTestCases(numberOfTestCases) )
        {
            System.out.print("\nEnter number of test cases > ");
            numberOfTestCases = getPositiveInteger();
        }

        return numberOfTestCases;
    }


    public static void main(String[] args) {
//        String test  = "5 + 3 = 5machula4";
//        String test1 = "500 - 400 = 4machula0";
//        String test2 = "5 * 20 = 5machula";
//        String test3 = "500 / 100 = 5machula0";
//        String test4 = "9 machula 5 = 45";
//        String test5 = "9 - 5 = 4";
//
//        System.out.println(processString(test));
//        System.out.println(processString(test1));
//        System.out.println(processString(test2));
//        System.out.println(processString(test3));
//        System.out.println(processString(test4));
//        System.out.println(processString(test5));

        System.out.println("2157 ABSYS - Anti-Blot System\n" +
                "\n" +
                "Jimmy is a hard-working pupil in his second year at primary school. \n" +
                "Recently he decided to convert all his notes into an electronic version. \n" +
                "Sadly, he found that his math notes were full of ink blots.\n" +
                "\n" +
                "He scanned the notes and sent them through his own OCR package \n" +
                "(yes, he coded it all by himself at the age of 8). The OCR package \n" +
                "replaced all ink blots by the string \"machula\".\n\n" +
                "In this program you will type in the lines of equations\n" +
                "returned by the OCR package, and the program will\n" +
                "repair them, then print them out.");

        int numberOfTestCases;
        numberOfTestCases = getNumberOfTestCases();

        String answers[] = new String[numberOfTestCases];
        for(int i=0; i<numberOfTestCases; i++)
        {
            try {
                System.out.print("Enter equation to correct: ");
                answers[i] = processString(keyboard.nextLine());
            }
            catch (Exception e) {
                System.out.println( "Error - try entering the equation again." );
                i--;
            }
        }

        System.out.println("\n---- Results ----");

        for(String s : answers)
            System.out.println(s);

    }

}
