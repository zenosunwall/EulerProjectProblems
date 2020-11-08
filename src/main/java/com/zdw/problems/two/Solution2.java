package com.zdw.problems.two;

/**
 * 1 1 2 3 5 8 13 21 34 55 89 144 ...
 * a b c a b c a  b  c  a  b  c
 * 
 * Seeing that c is always even the function can be rewritten.  
 * This is due to the addition rules of odd + odd = even and odd + even = odd
 * 
 * odd + odd = even
 * odd + even = odd
 * even + odd = odd
 * and repeat.
 * 
 * @author Zebulun
 *
 */

public class Solution2 {
	public static void main(String[] args)
	{
		System.out.print(calculateSum(4000000));
	}
	
	public static int calculateSum(int limit)
	{
		int sum=0;
		int a=1;
		int b=1;
		int c=2;
		while (c<limit)
		{
			sum+=c;
			a=b+c;
			b=c+a;
			c=a+b;
		}
		return sum;
	}
}
