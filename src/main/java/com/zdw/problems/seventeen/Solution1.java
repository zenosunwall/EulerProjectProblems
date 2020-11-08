package com.zdw.problems.seventeen;

/**
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage.

 * @author Zebulun
 *
 */

public class Solution1 {
	private static String[] zeroToNineteen = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "tweleve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static String[] tenToOneHundredByTen = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	private static String hundred = "hundred";
	private static String oneThousand = "one thousand";
	private static String and = "and";
	private static String space = " ";
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 1000; i++)
		{
			sb.append(numberToWord(i));
		}
		String finalString = sb.toString().replaceAll("[-\s]", "");
		System.out.println(finalString.length());
	}

	public static String numberToWord(int n)
	{
		StringBuilder sb = new StringBuilder();
		if (n == 1000) return oneThousand;
		if (n > 100) 
		{	
			int hundreds = n / 100;
			if (n % 100 == 0)
			{
				return sb.append(zeroToNineteen[hundreds]).append(space).append(hundred).toString();
			}
			sb.append(zeroToNineteen[hundreds]).append(space).append(hundred).append(space).append(and).append(space);
		}
		if (n == 100) return sb.append(zeroToNineteen[1]).append(space).append(hundred).toString();
		n %= 100;
		if (n < 20) return sb.append(zeroToNineteen[n]).toString();
		int tens = n / 10;
		int ones = n % 10;
		sb.append(tenToOneHundredByTen[tens-1]);
		if (ones != 0) sb.append("-").append(zeroToNineteen[ones]);
		return sb.toString();
	}
}
