package com.zdw.problems.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * 
 * What is the 10,001st prime number?
 * 
 * @author Zebulun
 *
 */

public class Solution1 {
	static List<Long> primes= new ArrayList<>();
	
	public static void main(String [] args) {
		// 2 is the only even prime
		primes.add(2l);
		
		// 3 is the first odd prime
		long testCase = 3;
		
		while (primes.size() < 10001)
		{
			if (isPrime(testCase))
			{
				primes.add(testCase);
			}
			testCase += 2;
		}
		System.out.println(primes.get(10000));
	}
	
	public static boolean isPrime(long number)
	{
		for (long prime : primes)
		{
			if (prime * prime > number)
			{
				return true;
			}
			if (number % prime == 0)
			{
				break;
			}
		}
		return false;
	}
}
