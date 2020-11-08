package com.zdw.problems.four;

import java.util.SortedSet;
import java.util.TreeSet;

import com.zdw.lib.math.Arithmetic;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Zebulun
 *
 */

public class Solution1 {
	public static void main(String[] args) {
		SortedSet<Integer> palindroms = new TreeSet<Integer>();
		for (int i = 999; i > 900; i--)
		{
			for (int j = 999; j > 900; j--) {
				if (i * j == Arithmetic.flipNumber(i * j))
				{
					System.out.println(i + " * " + j + " = " + i*j);
					palindroms.add(i * j);
				}
			}
		}
		System.out.println(palindroms.last());
	}
}
