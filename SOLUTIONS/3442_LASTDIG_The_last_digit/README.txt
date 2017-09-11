3442 LASTDIG - The last digit

Nestor was doing the work of his math class about three days but he is tired of make operations 
a lot and he should deliver his task tomorrow. 
His math’s teacher gives him two numbers a and b. 
The problem consist of finding the last digit of the potency of base a and index b. 
Help Nestor with his problem. 

You are given two integer numbers: 
	the base a (0 <= a <= 20) 
	and the index b (0 <= b <= 2,147,483,000), 

a and b both are not 0. You have to find the last digit of ab.

Input

The first line of input contains an integer t, the number of test cases (t <= 30). 
t test cases follow. For each test case will appear a and b separated by space.

Output

For each test case output an integer per line representing the result.

Example

Input:
2
3 10
6 2

Output:
9
6



========================================================================
patterns 

index 0 is always 1
index 1 is always base					*										*										*
									  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
									  
base 2 - 1 2 4 8 16 32 64 128 256	  1 2 4 8 6 2 4 8 6
base 3 -							  1 3 9 7 1 3 9 7 1 3 9 7 1 3 9 7 1 3 9 7 1 3 9 7 1 3 9 7 1 3 9 7 1 3 9 7 1 3 9 7 1 3
base 4 -							  1 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4 6 4
base 5 -							  1 5 5 5 5 5 5 5 5
base 6 -							  1 6 6 6 6 6 6 6 6
base 7 -							  1 7 9 3 1 7 9 3 1 7 9 3 1
base 8 -							  1 8 4 2 6 8 4 2 6
base 9 -							  1 9 1 9 1 9 1 9 1
base 10 -							  1 0 0 0 0 0 0 0 0
base 11 -							  1 1 1 1 1 1 1 1 1
base 12 -							  1 2 4 8 6 2 4 8 6
base 13 -							  1 3 9 7 1 3 9 7 1


Patterns repeat every 4 so sequence restarts every 20
to get the position get the last two numbers and mod by 20

eg	 1000092					   base 7
	 1000092 >> 2
	   10000
	 10000 << 2
	 1000000
	 1000092 - 1000000
		  92
	 92 % 20
		  12
		  
result = 1
		  
===============================	  
solution 1
===============================
7 1000092

7^12 %10   == 1		   
Problem Big Numbers for power

===============================	  
solution 2

how to get 1 2 3 or 4? (easier for powers)






		  
		  