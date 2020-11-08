package com.zdw.problems.four;

import com.zdw.lib.math.Arithmetic;

/**
 * Assuming that a and b are going to be as close to 1000 as possible to get the largest 6 digit palindrome.  
 * It should be sufficient to count down from 999 
 * but we don't need to check 999*998 and 998*999 due to the multiplication Commutative Law.
 * 
 * In order to fix this an assumption can be made of a <= b removing the chance for double calculations.
 * 
 * 
 * @author Zebulun
 *
 */

public class Solution2 {
	public static void main(String[] args)
	{
		System.out.println(findLargestPalindrome());
	}
	
	private static int findLargestPalindrome()
	{
		int largestPalindrome = 0;
		int a = 999;
		while (a>=100)
		{
			int b = 999;
			while (b>=a)
			{
				if (a*b <= largestPalindrome) break; // Already too small stop while loop.
				if (a*b == Arithmetic.flipNumber(a*b)) largestPalindrome = a*b;
				b--;
			}
			a--;
		}
		return largestPalindrome;
	}
}
