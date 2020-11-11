package com.zdw.problems.one;

/**
 * 
 * Since a=3+6+9... is all the sums of 3
 * and b=5+10+15... is all the sums of 5
 * and c=15+30+30... is all the intersecting sums
 * Can rewrite the function as a+b-c=sum
 * 
 * @author Zebulun
 *
 */

public class Solution2 {
	public static int sumMulitplesToMax(int number, int max)
	{
		int sum = 0;
		for (int n = number; n <= max; n += number)
		{
			sum += n;
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		System.out.println(sumMulitplesToMax(3, 100) 
				+ sumMulitplesToMax(5, 100) 
				- sumMulitplesToMax(15, 100));
	}
}
