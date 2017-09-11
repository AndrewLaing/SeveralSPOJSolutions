394 ACODE - Alphacode

Alice and Bob need to send secret messages to each other and are discussing ways to encode 
their messages:

  Alice: “Let’s just use a very simple code: We’ll assign ‘A’ the code word 1, ‘B’ will be 2, 
		 and so on down to ‘Z’ being assigned 26.”

  Bob: “That’s a stupid code, Alice. Suppose I send you the word ‘BEAN’ encoded as 25114. 
		You could decode that in many different ways!”

  Alice: “Sure you could, but what words would you get? Other than ‘BEAN’, you’d get ‘BEAAD’, 
		 ‘YAAD’, ‘YAN’, ‘YKD’ and ‘BEKD’. I think you would be able to figure out the correct 
		  decoding. And why would you send me the word ‘BEAN’ anyway?”
 
  Bob: “OK, maybe that’s a bad example, but I bet you that if you got a string of length 5000 
	   there would be tons of different decodings and with that many you would find at least 
	   two different ones that would make sense.”

  Alice: “How many different decodings?”

  Bob: “Jillions!”

For some reason, Alice is still unconvinced by Bob’s argument, so she requires a program 
that will determine how many decodings there can be for a given string using her code.

Input

Input will consist of multiple input sets. 
Each set will consist of a single line of at most 5000 digits representing a valid encryption 
(for example, no line will begin with a 0). 
There will be no spaces between the digits. 
An input line of ‘0’ will terminate the input and should not be processed.

Output

For each input set, output the number of possible decodings for the input string. 
All answers will be within the range of a 64 bit signed integer.

Example

Input:

25114
1111111111
3333333333
0

Output:

6
89
1


==============================================================================================
==============================================================================================
==============================================================================================

﻿===============================================================
					 Algorithms for ACODE
===============================================================

1: STORE THE STRING GLOBALLY

2: Dynamic Programming (also known as dynamic optimization) 
   is a method for solving a complex problem by breaking it down 
   into a collection of simpler subproblems, solving each of those 
   subproblems just once, and storing their solutions.

Dynamic Programming Properties

An instance is solved using the solutions for smaller instances.
The solutions for a smaller instance might be needed multiple times, 
so store their results in a table. Thus each smaller instance is 
solved only once. Additional space is used to save time.

Dynamic Example: Fibonacci

For solving more than one test case, previous results are cached so
for the second test case it checks if it has already been found and
cached, if not then it starts from the end of the cache adding on
new answers.

This approach is good when more than one test case is used but adds
overhead for solving a single problem. However in the SPOJ problems
there are multiple test cases.

see also: http://prismoskills.appspot.com/lessons/Dynamic_Programming/Chapter_01_-_Introduction.jsp
		  https://www.javacodegeeks.com/2014/02/dynamic-programming-introduction.html
		  https://www.hackerearth.com/practice/notes/dynamic-programming-for-beginners-part-1/
		  https://www.youtube.com/watch?v=OQ5jsbhAv_M

---------------------------------------------------------------
Source: Python. 

cache = {}

def fibonacci(n):
	cache[0] = 0
	cache[1] = 1

	for i in range(2, n + 1):
		cache[i] = cache[i - 1] +  cache[i - 2]

	return cache[n]

---------------------------------------------------------------



----------------------------------------------------------------
1-Input followed by output 
Check all the strings and see if u get the correct result if u do submit the code 

123456789 
3 
987654321 
2 
1234567890		  # invalid string no chars begin with 0
0 
543212345 
5 
123454321 
6 
111111111 
55 
333333333 
1 
919 
2 
101 
1 
100				  # invalid string no chars begin with 0
0 
50				  # invalid string no chars begin with 0
0 
10
1
25114 
6 
99 
1 
865723149 
4 
1006598736254	  # invalid string no chars begin with 0
0 
96587412359875 
3 
