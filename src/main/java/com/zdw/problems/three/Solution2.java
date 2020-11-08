package com.zdw.problems.three;

/**
 * Prime Factorization to find the expression quicker.
 * 
 * Also the factor(f) of a number(n) is less than or equal to the square root of n.
 * and since Math.sqrt() needs a double.  Will use f*f <= n for the comparison.  
 * 
 * This does run the risk of getting a number larger than a long. 
 * Which could result in an exception, 
 * however that number would need to be a large prime number close to 2^64.
 * 
 * @author Zebulun
 *
 */

public class Solution2 {
	public static void main(String [] args) {
		System.out.println(findLargestPrime(600851475143l));
	}
	
	public static long findLargestPrime(long number)
	{
		if (number == 1l) return 1l;
		long n = number;
		int largestFactor;
		if (n % 2 == 0)
		{
			largestFactor = 2;
			n /= 2;
			while (n % 2 == 0) {
				n /= 2;
			}
		} else
		{
			largestFactor = 1;
		}
		
		int factor = 3;
		while(n > 1 && factor*factor <= n) {
			if (n % factor == 0)
			{
				largestFactor = factor;
				n /= factor;
				while(n % factor == 0) n /= factor;
			}
			factor+=2;
		}
		if (n==1) return largestFactor;
		return n;
	}
}
