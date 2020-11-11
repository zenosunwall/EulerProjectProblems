package com.zdw.problems.twentyeight;

/**

Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

@author Zebulun
 */

/*
43 44 45 46 47 48 49
42 21 22 23 24 25 26
41 20  7  8  9 10 27
40 19  6  1  2 11 28
39 18  5  4  3 12 29
38 17 16 15 14 13 30
37 36 35 34 33 32 31

Since 2 rows are always added

1 3x3 5x5 7x7 ... 1001x1001

 1 
 3  5  7  9  (+2)(row count - 1)
13 17 21 25  (+4)
31 37 43 49  (+6)
...
 */

public class Solution1 {
	public static void main(String[] args)
	{
		// 1 is a special case due to being the starting row.
		int sum = 1;
		int numberToAdd = 1;
		for (int rowcount = 3; rowcount <=1001; rowcount+=2)
		{
			// 4 diagonal numbers per each box
			for (int i = 0; i < 4; i++)
			{
				numberToAdd += rowcount - 1;
				sum += numberToAdd;
			}
		}
		System.out.println(sum);
	}
}
