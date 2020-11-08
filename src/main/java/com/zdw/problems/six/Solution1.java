package com.zdw.problems.six;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1+2+...10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
 * 
 * 3025 - 385 = 2640
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * @author Zebulun
 *
 */

public class Solution1 {

	public static void main(String[] args) {
		double squaresSum = 0;
		double naturalSquare = 0;
		for (double i = 1; i <= 100; i++) {
			squaresSum += (Math.pow(i, 2l));
		}
		for (double i = 1; i <= 100; i++) {
			naturalSquare += i;
		}
		System.out.println(squaresSum);
		System.out.println(naturalSquare);
		naturalSquare = Math.pow(naturalSquare, 2l);
		System.out.println(naturalSquare);
		System.out.print((naturalSquare - squaresSum));
	}
	
}
