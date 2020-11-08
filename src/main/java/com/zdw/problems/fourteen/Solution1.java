package com.zdw.problems.fourteen;

/**
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

@author Zebulun
*/

public class Solution1 {
	public static void main(String[] args)
	{
		int max = 0;
		long maxTerm = 0;
		
		for (long i = 1; i <= 1000000; i++)
		{
			long currentTerm = i;
			int count = 1;
			while(currentTerm != 1) 
			{
				currentTerm = nextCollatz(currentTerm);
				count++;
			}
			if (count > max) 
			{
				max = count;
				maxTerm = i;
			}
		}
		System.out.println(max);
		System.out.println(maxTerm);
	}
	
	public static long nextCollatz(long number)
	{
		if (number % 2 == 0) return number / 2;
		return 3*number + 1;
	}
}
