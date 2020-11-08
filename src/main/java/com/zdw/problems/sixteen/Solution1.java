package com.zdw.problems.sixteen;

import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * @author Zebulun
 *
 */

public class Solution1 {
	public static void main(String[] args) {
		BigInteger bi = BigInteger.TWO;
		bi = bi.pow(1000);
		char[] characters = bi.toString().toCharArray();
		long sum = 0;
		for (char character : characters)
		{
			System.out.print(character);
			sum += character - '0';
		}
		System.out.println();
		System.out.println(sum);
	}
}
