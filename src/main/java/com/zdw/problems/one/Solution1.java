package com.zdw.problems.one;

import java.util.HashSet;
import java.util.Set;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.

 * @author Zebulun
 *
 */

public class Solution1 {
	public static void main(String[] args) {
		Set<Integer> multiples = new HashSet<>();
		Integer sum = 0;
		
		for (int i = 3; i < 1000; i+= 3)
		{
			multiples.add(i);
		}
		
		for (int i = 5; i < 1000; i+= 5)
		{
			multiples.add(i);
		}
		
		for (Integer value : multiples)
		{
			sum += value;
		}
		
		System.out.println(sum);
	}
}
