package com.zdw.problems.two;

/**
 * 
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 * 
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 * 
 * @author Zebulun
 *
 */

public class Solution1 {
	public static void main(String[] args) {
		Integer sum = 2;
		
		Integer prev = 1;
		Integer current = 2;
		Integer next = nextValue(prev, current);
		
		System.out.println("1, \n2, ");
		
		while(next < 4000000)
		{
			System.out.println(next + ", ");
			if (next % 2 == 0)
			{	
				sum += next;
			}
			prev = current;
			current = next;
			next = nextValue(prev, current);
		}
		
		System.out.print("final sum is: " + sum);
	}
	
	public static int nextValue(int prev, int current)
	{
		return prev + current;
	}
}