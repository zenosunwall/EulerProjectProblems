package com.zdw.problems.twentythree;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.zdw.lib.math.Arithmetic;

/**
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

@author Zebulun
 */

public class Solution1 {
	static SortedSet<Integer> abundantNumbers = new TreeSet<Integer>();
	static SortedSet<Integer> nonAbundantSums = new TreeSet<Integer>();
	
	public static void main(String [] args)
	{
		// find abundant numbers
		for (int i = 1; i < 28123; i++)
		{
			if (isAbundantNumber(i)) abundantNumbers.add(i);
		}
		for (int i = 1; i <= 28123; i++)
		{
			for (Integer abundantNumber : abundantNumbers) {
				if (abundantNumber > i) nonAbundantSums.add(i);
				else if (abundantNumbers.contains(i - abundantNumber)) break;
			}
		}
		System.out.println(nonAbundantSums);
		int sum = 0;
		for (Integer nonAbundantSum : nonAbundantSums)
		{
			sum += nonAbundantSum;
		}
		System.out.println(sum);
	}
	
	public static boolean isAbundantNumber(int number)
	{
		int sum = 0;
		Set<Integer> factors = Arithmetic.getFactorsNotIncludingItself(number);
		for (Integer factor : factors)
		{
			sum += factor;
		}
		return sum > number;
	}
}
