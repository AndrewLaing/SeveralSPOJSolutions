/**
 * Filename:
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        20/08/2017.
 * Description:
 */

import java.util.EmptyStackException;
import java.util.Scanner;

public class Solution1
{
    private static Scanner keyboard = new Scanner(System.in);
    private static char stack[] = new char[400];
    private static int nextStackPos = 0;

    /**
     * The method isEmpty returns true if the stack is empty,
     * otherwise false.
     * @return True if the stack is empty, otherwise false.
     */
    private static boolean isEmpty() {
        return nextStackPos == 0;
    }


    /**
     * The method push pushes a char to the top of the stack.
     * @param c A char to push to the top of the stack.
     */
    private static void push(char c) {
        stack[nextStackPos++] = c;
    }


    /**
     * The method pop returns the char at the top of the stack.
     * @return The char at the top of the stack.
     */
    private static char pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        nextStackPos--;
        return stack[nextStackPos];
    }


    /**
     * The method isValidLengthExpression verifies that the expression
     * passed has a length in the range 1 to 400. If so it returns true,
     * otherwise false.
     * @param s A String to validate the length for.
     * @return True if the String has a length in the range 1 to 400,
     *         otherwise false.
     */
    private static boolean isValidLengthExpression(String s) {
        return ( s.length() > 0 ) && ( s.length() <= 400 );
    }


    /**
     * The method isValidNumberOfTestCases returns true if the int passed
     * is in the range 0 to 100, otherwise false.
     * @param n An int to test.
     * @return True if the int passed is in the range 0 to 100, otherwise false.
     */
    private static boolean isValidNumberOfTestCases(int n) {
        return (n >= 0) && ( n <= 100);
    }


    /**
     * The method isOperator returns true if the character passed is a valid
     * operator, otherwise false.
     * @param c A char to test.
     * @return True if the character passed is a valid operator, otherwise false.
     */
    private static boolean isOperator(char c) {
        boolean res = false;
        switch(c) {
            case '/': case '*': case '-': case '+': case '^':
                res = true;
                break;
            default:
                break;
        }
        return res;
    }


    /**
     * The method processExpression transforms the expression passed to it
     * into Reverse Polish Notation.
     * @param expression An String containing an expression to transform.
     * @return A String containing the transformed expression.
     */
    private static String processExpression( String expression )
    {
        /* Use StringBuffer rather than StringBuilder because this program
         * does not contain any threads */
        StringBuilder sb = new StringBuilder();
        char c;

        /* Transform the expression */
        for( int i=0; i<expression.length() ; i++ ) {
            c = expression.charAt(i);

            if(c==' ')
                continue;
            else if(c=='(')
                push( c );
            else if( isOperator( c ) )
                push( c );
            else if(c==')') {
                c = pop();
                while(c != '(') {
                    sb.append( c );
                    c = pop();
                }
            }
            else
                sb.append( c );
        }

        /* If the stack is not empty then it was an illegal expression */
        if( !isEmpty() ) {
            throw new IllegalStateException();
        }

        return sb.toString();
}


    public static void main(String[] args) {
        int numberOfTestCases;
        int expressionsAdded = 0;
        String input;

        /* Get the number of expressions to enter */
        System.out.print("Enter number of test cases > ");
        numberOfTestCases = keyboard.nextInt();
        keyboard.nextLine(); /* consume the newline */

        while( !isValidNumberOfTestCases( numberOfTestCases) ) {
            System.out.println("Error - number of test cases must be in the range 0 - 100 ");
            System.out.print("Enter number of test cases > ");
            numberOfTestCases = keyboard.nextInt();
        }

        /* Create an array to hold the results */
        String results[] = new String[numberOfTestCases];

        /* Enter the expressions, transform them, and add them to the results array */
        for( int i=0; i<numberOfTestCases; i++ ) {
            nextStackPos = 0;  /* reset the stack pointer */

            System.out.print("Enter expression > ");
            input = keyboard.nextLine();

            /* Validate expression length*/
            if(!isValidLengthExpression( input )) {
                System.out.println("Error - expression length must be in the range 1 - 400 ");
                i--;
                continue;
            }

            /* Skip expressions in square brackets */
            if(input.charAt(0)=='[') continue;

            /* Process the expression and add the result to the results array */
            try {
                results[i] = new String(processExpression(input));
                expressionsAdded++;
            }
            catch( EmptyStackException e) {
                System.out.println("Error - invalid expression.");
                i--;
                continue;
            }
            catch( IllegalStateException es) {
                System.out.println("Error - invalid expression.");
                i--;
                continue;
            }
        }

        /* Print out the transformed expressions */
        System.out.println("\n---- Results ----\n");
        for(int i=0; i<expressionsAdded; i++) {
            System.out.println(results[i]);
        }
    }
}
