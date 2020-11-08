package com.zdw.problems.twentyone;

import java.util.ArrayList;
import java.util.List;

/**
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

@author Zebulun
 */

public class Solution1 {
	public static void main(String[] args) {
		int sumOfAmicable = 0;
		for (int i = 1; i <= 10000; i++) 
		{
			// d(a)
			int sum = sumAll(getFactorsNotIncludingItself(i));
			// if ( d(a) > a ) && d(b) = a
			if (sum > i && sumAll(getFactorsNotIncludingItself(sum)) == i)
			{
				sumOfAmicable += sum;
				sumOfAmicable += i;
			}
		}
		
		System.out.println(sumOfAmicable);
	}
	
	public static List<Integer> getFactorsNotIncludingItself(int number)
	{
		List<Integer> factors = new ArrayList<>();
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
	
	public static int sumAll(List<Integer> numbers)
	{
		int sum = 0;
		for (int number : numbers)
		{
			sum += number;
		}
		return sum;
	}

	public static boolean divisibleBy(int dividend, int divisor) 
	{
		return dividend % divisor == 0;
	}
}
