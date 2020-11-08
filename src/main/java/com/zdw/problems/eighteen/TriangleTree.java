package com.zdw.problems.eighteen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TriangleTree {
	Map<Integer, Integer[]> triangle = new HashMap<>();
	
	public TriangleTree(String triangleString) {
		Scanner sc = new Scanner(triangleString);
		int row = 0;
		while (sc.hasNextInt())
		{
			Integer [] rowValues = new Integer[row+1];
			for(Integer i = 0; i <= row; i++)
			{
				rowValues[i] = sc.nextInt();
			}
			this.triangle.put(row, rowValues);
			row++;
		}
		sc.close();
	}
	
	/**
	 * Goes bottom up to calculate the sum
	 * 
	 * @return
	 */
	public int findLargestSumPath()
	{
		Integer[] maxSum = triangle.get(triangle.size() - 1);
		for (int i = triangle.size() - 2; i >=0; i--)
		{
			for (int rowIndex = 0; rowIndex < triangle.get(i).length; rowIndex++)
			{
				int leftSum = calcLeftSizeSum(i, rowIndex, maxSum);
				int rightSum = calcRightSizeSum(i, rowIndex, maxSum);
				
				if (leftSum > rightSum)
				{
					maxSum[rowIndex] = leftSum;
				} else maxSum[rowIndex] = rightSum;
			}
		}
		return maxSum[0];
	}

	private int calcRightSizeSum(int i, int pos, Integer[]maxSum) 
	{
		return triangle.get(i)[pos] + maxSum[pos+1];
	}

	private int calcLeftSizeSum(int i, int pos, Integer[]maxSum) 
	{
		return triangle.get(i)[pos] + maxSum[pos];
	}
	
}


