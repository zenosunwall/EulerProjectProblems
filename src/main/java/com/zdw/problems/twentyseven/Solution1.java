package com.zdw.problems.twentyseven;

import java.util.ArrayList;
import java.util.List;

import com.zdw.lib.math.Arithmetic;

/**
Euler discovered the remarkable quadratic formula:

n^2 + n + 41

It turns out that the formula will produce 40 primes for the consecutive integer values 0 <= n <= 39. 
However, when n = 40,40^2 + 40 + 41 = 40(40+1) + 41 is divisible by 41, 
and certainly when n=41, 41^2 + 41 + 41 is clearly divisible by 41.

The incredible formula n^2 - 79n + 1601 was discovered,
 which produces 80 primes for the consecutive values 0 <= n <= 79. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:
n^2 + an + b, where |a| < 1000 and |b| <= 1000
where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |-4| = 4

Find the product of the coefficients, a
and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
 * @author Zebulun
 *
 */

/*
 * P = n^2 + an + b
 * Note: n=0 then P=b means that b must be a prime number.
 * 
 * a is between -999 and 999.
 * 
 * Since all prime numbers are positive integers greater than 1
 * 
 * n=1
 * then 1 + a + b > 1
 * b > -a
 * 
 * Therefore a can start at -b and move to 999;
 */

public class Solution1 {
	
	public static void main(String[] args)
	{
		// Get values of b
		List<Integer> primes = Arithmetic.generatePrimesToN(1000);
		
		
		QuadraticEquation result = new QuadraticEquation(0, 0);
		int maxPrimes = 0;
		
		for (int b : primes)
		{
			for (int a = b * -1; a < 1000; a++)
			{
				int n = 0;
				int primeCount = 0;
				QuadraticEquation qe = new QuadraticEquation(a, b);
				while(Arithmetic.isPrime(qe.calculateQuadratic(n)))
				{
					primeCount++;
					n++;
				}
				if (primeCount > maxPrimes)
				{
					result = qe;
					maxPrimes = primeCount;
				}
			}
		}
		
		System.out.println(result.getA());
		System.out.println(result.getB());
		System.out.println(maxPrimes);
		System.out.println(result.getA() * result.getB());
	}
	
}
