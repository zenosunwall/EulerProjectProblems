package com.zdw.problems.twentyfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

@author Zebulun
 */

/*
 * if we start at 0
 * 
 * 0: 0123
 * 1: 0132
 * 2: 0213
 * and so on
 * 
 * we can see a pattern that we move every 1,2,6,24 and so on for each position
 * 
 * we reorder the numbers below the part that moves with each move ex.
 * 0321
 * 1023
 * 
 * we can derive a formula for each position
 * 
 * p-1! is the number of combinations we need to move this position one to the right.
 * 
 * n-1 since we started at zero
 * 
 * lead position is n-1/p-1! = m where we move right m positions
 * 
 * To get the next position we need to remove the possibilities so n-m*(p-1)!.
 * 
 * and the chosen element needs to be removed from the array because it is no longer a possibility.
 * 
 * Then repeat for each spot where the last position is the remaining spot.
 * 
 */

public class Solution1 {
	public static void main(String[] args) {
		Character[] testValue = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		System.out.println(getLexicographicPermutationAtN(testValue, 1000000));
	}

	public static List<Character> getLexicographicPermutationAtN(Character[] value, int n) {
		List<Character> originalCopy = new ArrayList<>();
		originalCopy.addAll(Arrays.asList(value));
		List<Character> nthPermutation = new ArrayList<>();
		int[] permutationIncrease = new int[value.length];
		permutationIncrease[0] = 1;
		for (int i = 1; i < value.length; i++)
		{
			permutationIncrease[i] = i * permutationIncrease[i-1];
		}
		System.out.println(Arrays.toString(permutationIncrease));
		n--;
		for (int i = permutationIncrease.length - 1; i > 0; i--)
		{
			System.out.println(n + " / " + permutationIncrease[i]);
			int pos = n / permutationIncrease[i]; 
			System.out.println("= " + pos);
			Character nthPosChar = originalCopy.remove(pos);
			nthPermutation.add(nthPosChar);
			System.out.println(nthPosChar);
			n -= pos*permutationIncrease[i];
		}
		nthPermutation.add(originalCopy.remove(0));
		return nthPermutation;
	}
}
