package com.zdw.problems.twentynine;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

/**

Consider all integer combinations of a^b for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:

    2^2=4, 2^3=8, 2^4=16, 2^5=32
    3^2=9, 3^3=27, 3^4=81, 3^5=243
    4^2=16, 4^3=64, 4^4=256, 4^5=1024
    5^2=25, 5^3=125, 5^4=625, 5^5=3125

If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:

4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125

How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?

@author Zebulun
 */

public class Solution1 {
	public static void main(String[] args)
	{
		Set<BigDecimal> bdSet = new TreeSet<BigDecimal>();
		for (int i = 2; i < 101; i++)
		{
			BigDecimal bd = new BigDecimal(i);
			for (int p = 2; p < 101; p++)
			{
				bdSet.add(bd.pow(p));
			}
		}
		System.out.println(bdSet.size());
	}
}
