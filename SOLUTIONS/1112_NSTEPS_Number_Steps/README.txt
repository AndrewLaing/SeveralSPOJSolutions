1112 NSTEPS - Number Steps

Starting from point (0,0) on a plane, we have written all non-negative integers 
0, 1, 2,... as shown in the figure. For example, 1, 2, and 3 has been written
at points (1,1), (2,0), and (3, 1) respectively and this pattern has continued.

y |                     .
6 |                   12                  
5 |                9     11
4 |             8     10
3 |          5     7
2 |       4     6
1 |    1     3
0 | 0     2
--------------------------
  | 0  1  2  3  4  5  6  7 x

You are to write a program that reads the coordinates of a point (x, y), 
and writes the number (if any) that has been written at that point. 
(x, y) coordinates in the input are in the range 0...10000.
 

Input

The first line of the input is N, the number of test cases for this problem. 
In each of the N following lines, there is x, and y representing the coordinates (x, y) 
of a point.

 

Output

For each point in the input, write the number written at that point or write No Number 
if there is none.


Example

Input:
3
4 2
6 6
3 4

Output:
6
12
No Number

------------------------------------------------------------------------------------------

SOLUTION in C++

#include <iostream>


using namespace std;



/* /// PROTOTYPES /// */


int getNumberStep( int, int );



/* /// FUNCTIONS /// */


int getNumberStep(int x, int y)

{

    if(y<0 || x < 0)

        return -1;

    if( y!=x && y+2!=x )

        return -1;
    

    if(x<2)

        return x;

    else if(x == 2 || x%2==0)

        return x+y;

    else

        return x+y-1;

}





int main()

{

    int test, x, y;

    
x=4, y=2;

    test = getNumberStep(x, y);
    if( test != -1 )

        cout << x << "," << y << " = " << test << endl;

    else

        cout << x << "," << y << " = No number." << endl;


    
x=6, y=6;

    test = getNumberStep(x, y);
    if( test != -1 )

        cout << x << "," << y << " = " << test << endl;

    else

        cout << x << "," << y << " = No number." << endl;

    
x=3, y=4;

    test = getNumberStep(x, y);
    if( test != -1 )

        cout << x << "," << y << " = " << test << endl;

    else

        cout << x << "," << y << " = No number." << endl;

    return 0;

}


