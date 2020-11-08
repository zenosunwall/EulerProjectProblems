package com.zdw.lib.math;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Arithmetic {
	/**
	 * Reverses the digits of number n
	 * 
	 * @param n
	 * @return
	 */
	public static int flipNumber(int n) {
		int n2 = 0;
		while (n != 0) {
			int digit = n % 10;
			n2 = n2 * 10 + digit;
			n /= 10;
		}
		return n2;
	}
	
	/**
	 * Returns true if dividend / divisor results in a remainder of 0
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static boolean divisibleBy(int dividend, int divisor) 
	{
		return dividend % divisor == 0;
	}

	/**
	 * Returns the square of n
	 * 
	 * @param i
	 * @return
	 */
	public static int square(int n)
	{
		return n*n;
	}
	
	/**
	 * Returns true if n is prime
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(long n)
	{
		// prime number start at 2
		if (n < 2) return false; 
		// 2 and 3 are prime
		if (n < 4) return true;
		// if even and not 2 are not prime
		if (n % 2 == 0) return false;
		// handles 5 7
 		if (n < 9) return true;
		// multiples of 3 are not prime
 		if (n % 3 == 0) return false;
 		// square root of n is the highest value that is possible to go into n
 		// primes > 3 are 6k+/-1
 		int testFactor = 5;
 		while (testFactor*testFactor <= n)
 		{
 			if (n % testFactor == 0) return false;
 			if (n % (testFactor+2) == 0) return false;
 			testFactor+=6;
 		}
 		return true;
	}
	
	/**
	 * Returns the larger of first and second
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static int max(int first, int second) {
		if (first > second) return first;
		return second;
	}
	
	/**
	 * Return number!
	 * 
	 * @param number
	 * @return
	 */
	public static BigInteger factorial(BigInteger number)
	{
		if (BigInteger.ONE.equals(number)) return number;
		return number.multiply(factorial(number.subtract(BigInteger.ONE)));
	}
	
	/**
	 * Returns the factors of number not including itself
	 * 
	 * @param number
	 * @return
	 */
	public static Set<Integer> getFactorsNotIncludingItself(int number)
	{
		Set<Integer> factors = new HashSet<>();
		factors.add(1);
		for (int i = 2; i*i <= number; i++)
		{
			if (divisibleBy(number, i))
			{
				factors.add(i);
				factors.add(number / i);
			}
		}
		
		return factors;
	}
}
