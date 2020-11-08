package com.zdw.problems.ten;

import com.zdw.lib.math.Arithmetic;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * @author Zebulun
 *
 */

public class Solution1 {
	public static void main(String[] args) {
		long sum=2l;
		for (long i=3l; i<2000000; i+=2)
		{
			if (Arithmetic.isPrime(i))
			{
				sum+=i;
			}
		}
		print(sum);
	}
	
	public static void print(Object o)
	{
		System.out.println(o);
	}
}
