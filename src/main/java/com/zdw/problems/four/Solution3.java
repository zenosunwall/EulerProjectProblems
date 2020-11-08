package com.zdw.problems.four;

import com.zdw.lib.math.Arithmetic;

/**
 * Its possible to simplify even more.
 * 
 * Looking at the palindrome(P) as xyzzyx we can create an equation
 * 
 * P = 100000x + 10000y + 1000z + 100z + 10y + x
 * P = 100001x + 10010y + 1100z
 * P = 11(9091x + 910y + 100z)
 * 
 * 11 divisibility rule
 * 
 * 1-0+0-0+0-1 = 0 // divisible by 11
 * 1-0+0-1+0 = 0   // divisible by 11
 * 1-1+0-0 = 0     // divisible by 11
 * 
 * knowing that P has a factor of 11 and 11 is prime that means that a and/or b must be divisible by 11.
 * 
 * @author Zebulun
 *
 */

public class Solution3 {
	public static void main(String[] args)
	{
		System.out.println(largestPalindrome());
	}
	
	public static int largestPalindrome()
	{
		int largestPalindrome = 0;
		int a = 999;
		while (a >= 100)
		{
			int b;
			boolean aIsDivisibleBy11;
			if (a % 11 == 0) 
			{
				b=999;
				aIsDivisibleBy11 = true;
			}
			else
			{
				b=990; // first number divisible by 11 closest to 1000;
				aIsDivisibleBy11 = false;
			}
			while (b >= a)
			{
				if (a*b <= largestPalindrome) break;
				if (a*b == Arithmetic.flipNumber(a*b)) largestPalindrome = a*b;
				b -= aIsDivisibleBy11 ? 1 : 11;
			}
			a -= 1;
		}
		return largestPalindrome;
	}
}
