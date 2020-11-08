package com.zdw.problems.twenty;

import java.math.BigInteger;

import com.zdw.lib.math.Arithmetic;

/**
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

 * @author Zebulun
 *
 */

public class Solution1 {
	public static char zero = '0';
	
	public static void main(String[] args) {
		// Get Factorial
		BigInteger factorialAnswer = Arithmetic.factorial(new BigInteger("100"));
		// To Char Array
		char[] didgets = factorialAnswer.toString().toCharArray();
		// Add elements
		int sum = 0;
		for (char didget : didgets)
		{
			sum += didget - zero;
		}
		System.out.println(sum);
	}
}
