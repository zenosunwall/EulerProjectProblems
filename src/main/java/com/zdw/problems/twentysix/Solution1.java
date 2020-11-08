package com.zdw.problems.twentysix;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

    1/2	= 	0.5
    1/3	= 	0.(3)
    1/4	= 	0.25
    1/5	= 	0.2
    1/6	= 	0.1(6)
    1/7	= 	0.(142857)
    1/8	= 	0.125
    1/9	= 	0.(1)
    1/10	= 	0.1 

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

@author Zebulun
 */

public class Solution1 {
	public static void main(String[] args) {
		System.out.println(longestCycle(999));
	}

	public static int longestCycle(int n) {
		Map<Integer, Integer> numberCycle = new HashMap<>();
		// for 2 to n
		for (int i = 2; i <= n; i++) {
			int cycle = getCycleLength(i);
			numberCycle.put(i, cycle);
		}
		// which one is longest
		int maxCycle = 0;
		int maxCycleNumber = 0;
		System.out.println(numberCycle);
		for (Map.Entry<Integer, Integer> entry : numberCycle.entrySet()) {
			if (maxCycle < entry.getValue()) {
				maxCycle = entry.getValue();
				maxCycleNumber = entry.getKey();
			}
		}
		return maxCycleNumber;
	}
	
	public static int getCycleLength(int n)
	{
		if (n <= 1)
			throw new IllegalArgumentException("n must be greater than 1");
		MathContext mc = new MathContext(3000, RoundingMode.DOWN);
		// Get Decimal
		BigDecimal quotient = BigDecimal.ONE.divide(new BigDecimal(n), mc);
		// Check for cycle
		if (quotient.precision() < 3000)
			return 0; // finite number no cycles
		String quotientAsString = quotient.toString().substring(2);
		Cycle cycle = Cycle.findCycle(quotientAsString.toCharArray());
		return cycle.size();
	}
}
