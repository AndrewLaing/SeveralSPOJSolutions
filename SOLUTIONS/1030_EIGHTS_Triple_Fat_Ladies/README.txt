1030 EIGHTS - Triple Fat Ladies

Pattern Matchers have been designed for various sorts of patterns. Mr. HKP likes to observe 
patterns in numbers.  After completing his extensive research on the squares of numbers,
he has moved on to cubes. Now he wants to know all numbers whose cube ends in 888.

Given a number k, help Mr. HKP find the kth number (indexed from 1) whose cube ends in 888.

Input

The first line of the input contains an integer t, the number of test cases. 
t test cases follow.

Each test case consists of a single line containing a single integer k (1 <= k <= 2000000000000).

Output

For each test case, output a single integer which denotes the kth number whose cube ends in 888. 

Example

Input:
1
1

Output:
192


=================================================================================================
=================================================================================================
=================================================================================================


I found results that shows that the first starts at 192 and repeats every 250 afterwards.
So this is a simple n = 192 + 250*(k-1). (for k >= 1)

============
python proof
============
def endsInEights(x):
    if x<1000 and x!=888:
        return False
    y = (x//1000)*1000
    if x-y == 888
        return True
    else
        return False


def getCube(x):
    return x*x*x


for i in range(9,5000):
    if endsInEights( getCube(i) ):
        print(i)
    
192
442
692
942
1192
1442
1692
1942
2192
2442
2692
2942
3192
3442
3692
3942
4192
4442
4692
4942
