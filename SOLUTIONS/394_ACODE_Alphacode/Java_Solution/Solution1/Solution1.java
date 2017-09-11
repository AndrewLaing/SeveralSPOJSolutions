/**
 * Filename:
 * Author:		Andrew Laing
 * Email:		parisianconnections@gmail.com
 * Date:		04/09/2017.
 * Description: SPOJ Exercise - see README.md
 */

import java.util.*;			 /* For Scanner and List */
import java.math.BigInteger;

public class Solution1
{
	private static Scanner keyboard = new Scanner(System.in);


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

		// Validate the user's input.
		while(!isValidInt)
		{
			try {
				validatedInteger = new BigInteger(input);
				if(validatedInteger.compareTo( new BigInteger("0")) < 0)
				{
					System.out.println("<<< ERROR - must be a positive number >>>\n");
					System.out.print("Enter a valid number > ");
					validatedInteger = new BigInteger(input);
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
	 * The method isValidTestCaseValue checks whether the value to be used in
	 * a test case is within allowed limits.
	 * @param testCaseValue The value to be used for a test case.
	 * @return True if the value is within the allowed limits, otherwise false.
	 */
	public static boolean isValidTestCaseValue( BigInteger testCaseValue )
	{
		int length = testCaseValue.toString().length();
		boolean result = length>0 && length <=5000;

		if(!result)
			System.out.println("Error test case string length should be in the range 1 to 5000 characters long.");

		return result;
	}


	/**
	 * The method getTestCaseValue allows the user to input, and
	 * return a test case value.
	 * @return A test case value.
	 */
	private static String getTestCaseValue()
	{
		BigInteger testCaseValue;

		System.out.print( "Enter test case value > " );
		testCaseValue = getPositiveBigInteger();

		while(!isValidTestCaseValue(testCaseValue))
		{
			System.out.print( "Enter test case value > " );
			testCaseValue = getPositiveBigInteger();
		}

		return testCaseValue.toString();
	}


	private static BigInteger calculatePossibleNumberOfEncryptions( String encryption )
	{
		int encLength = encryption.length();
		BigInteger dpArray[] = new BigInteger[encLength+1];

		/* Initialise the first elements of dpArray */
		dpArray[0] = dpArray[1] = new BigInteger("1");

		for(int i = 2;i<=encLength; ++i)
		{
			dpArray[i] = new BigInteger("0");

			int n1 = encryption.charAt(i-2)-'0', n2 = encryption.charAt(i-1)-'0';

			if(n1==1 || (n1==2 && n2<=6))
				dpArray[i] = dpArray[i].add(dpArray[i-2]);
			if(n2!=0)
				dpArray[i] = dpArray[i].add(dpArray[i-1]);
		}

		return dpArray[encLength];
	}



	public static void main(String[] args)
	{
		System.out.println("394 ACODE - Alphacode\n" +
				"\n" +
				"Alice and Bob need to send secret messages to each other and are discussing ways to encode \n" +
				"their messages:\n" +
				"\n" +
				"  Alice: \"Let's just use a very simple code: We'll assign 'A' the code word 1, 'B' will be 2, \n" +
				"		  and so on down to 'Z' being assigned 26.\"\n" +
				"\n" +
				"  Bob: \"That's a stupid code, Alice. Suppose I send you the word 'BEAN' encoded as 25114. \n" +
				"		 You could decode that in many different ways!\"\n" +
				"\n" +
				"  Alice: \"Sure you could, but what words would you get? Other than 'BEAN', you'd get 'BEAAD', \n" +
				"		  'YAAD', 'YAN', 'YKD' and 'BEKD'. I think you would be able to figure out the correct \n" +
				"		   decoding. And why would you send me the word 'BEAN' anyway?\"\n" +
				" \n" +
				"  Bob: \"OK, maybe that's a bad example, but I bet you that if you got a string of length 5000 \n" +
				"		there would be tons of different decodings and with that many you would find at least \n" +
				"		two different ones that would make sense.\"\n" +
				"\n" +
				"  Alice: \"How many different decodings?\"\n" +
				"\n" +
				"  Bob: \"Jillions!\"\n" +
				"\n" +
				"For some reason, Alice is still unconvinced by Bob's argument, so she requires a program \n" +
				"that will determine how many decodings there can be for a given string using her code....\n" +
				"This is that program!!!\n");

		System.out.println("Enter each encrypted string on a single line, or enter 0 to quit.\n");

		List<BigInteger> answers = new ArrayList<BigInteger>();

		String input = getTestCaseValue();

		while( !input.equals("0"))
		{
			answers.add(calculatePossibleNumberOfEncryptions(input));
			input = getTestCaseValue();
		}

		// print answers
		System.out.println("\n---- Results ----");

		for(BigInteger bi : answers)
		{
			System.out.println( bi );
		}
	}
}
