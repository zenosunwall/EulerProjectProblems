package com.zdw.problems.fifteen;

import java.math.BigInteger;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 * 
 * @author Zebulun
 *
 */
public class Solution1 {
	/**
	 * Verticies work in pascals triangle
	 * Formula for finding based on size = 2n! / n!^2
	 * 
	 * Where n is the width of the grid.
	 */
	
	public static void main(String[] args) {
		BigInteger n = new BigInteger("40");
		BigInteger k = new BigInteger("20");
		BigInteger total = factoral(n).divide(square(factoral(k)));
		System.out.print(total);
	}
	
	public static BigInteger factoral(BigInteger number)
	{
		if (BigInteger.ONE.equals(number)) return number;
		return number.multiply(factoral(number.subtract(BigInteger.ONE)));
	}
	
	public static BigInteger square(BigInteger number)
	{
		return number.multiply(number);
	}
}
