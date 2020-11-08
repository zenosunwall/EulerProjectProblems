package com.zdw.problems.twentytwo;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?

@author Zebulun
 */

public class Solution1 {
static int beforeA = 'a' - 1;
	
	public static void main(String[] args) throws FileNotFoundException {
		List<String> names = new ArrayList<>();
		InputStream path = Solution1.class.getClassLoader().getResourceAsStream("p022_names.txt");
		try (Scanner sc = new Scanner(path))
		{
			sc.useDelimiter(",");
			while(sc.hasNext())
			{
				names.add(sc.next().replaceAll("\"", ""));
			}
		}
		Collections.sort(names);
		
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < names.size(); i++)
		{
			// Get name worth
			BigInteger worth = getNameWorth(names.get(i));
			// multiply it by position (i+1)
			BigInteger score = worth.multiply(new BigInteger(Integer.toString(i+1)));
			// add to sum
			sum = sum.add(score);
		}
		
		System.out.println(sum);
	}
	
	public static BigInteger getNameWorth(String name)
	{
		BigInteger sum = BigInteger.ZERO;
		name = name.toLowerCase();
		char[] nameChacters = name.toCharArray();
		for (char character : nameChacters) {
			sum = sum.add( new BigInteger(Integer.toString(character - beforeA)) );
		}
		return sum;
	}
}
