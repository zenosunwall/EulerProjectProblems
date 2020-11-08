package com.zdw.problems.five;

import com.zdw.lib.math.Arithmetic;

/**
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author Zebulun
 * 
 */

public class Solution1 {
	public static void main(String[] args) {
		int value = 19 * 20; // first possible number that could be divisible by numbers 1-20
		
		while(true) {
			boolean pass = true;
			for (int i = 2; i <= 20; i++) {
				if (!Arithmetic.divisibleBy(value, i)) {
					pass = false;
				}
			}
			if (pass) {
				break;
			} else {
				value += 20; // moves to the next number divisible by 20.  Sure this could be better optimized. 
			}
		}
		
		System.out.println(value);
	}
}
