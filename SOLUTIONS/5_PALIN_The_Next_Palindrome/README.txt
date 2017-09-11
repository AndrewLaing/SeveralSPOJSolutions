5 PALIN - The Next Palindrome

A positive integer is called a palindrome if its representation in the decimal system 
is the same when read from left to right and from right to left. 
For a given positive integer K of not more than 1000000 digits, write the value of the 
smallest palindrome larger than K to output. 
Numbers are always displayed without leading zeros.

Input

The first line contains integer t, the number of test cases. 
Integers K are given in the next t lines.

Output

For each K, output the smallest palindrome larger than K.

Example

Input:
2
808
2133

Output:
818
2222

=========================================================================================
=========================================================================================
=========================================================================================

public class HelloWorld
{
    
    private static int MAXINTVALUE = 10000000;
    
    private static boolean isPalindrome(String s)
    {
        int strLen = s.length();
        for(int i=0, j=strLen-1; i<strLen; i++, j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }
    
    
    private static int findNextPalindrome( int n )
    {
        for(int i=n; i<MAXINTVALUE; i++) {
            if(isPalindrome(Integer.toString( i )))
                return i;
        }
        
        return -1;
    }
    

    public static void main(String []args)
    {
        int n = 10021;
        String s = Integer.toString(n);
        
        System.out.println("Next Palindrome after 1021 is " + findNextPalindrome( 1021 ));        
        System.out.println("Next Palindrome after 808 is " + findNextPalindrome( 808 ));        
        System.out.println("Next Palindrome after 2013 is " + findNextPalindrome( 2013 ));        
        System.out.println("Next Palindrome after 10035 is " + findNextPalindrome( 10035 ));        
        System.out.println("Next Palindrome after 554645 is " + findNextPalindrome( 554645 ));        
        System.out.println("Next Palindrome after 54564 is " + findNextPalindrome( 54564 ));        
        System.out.println("Next Palindrome after 131 is " + findNextPalindrome( 131 ));        
        System.out.println("Next Palindrome after 98987 is " + findNextPalindrome( 98987 ));
    }
}
