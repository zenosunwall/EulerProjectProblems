package com.zdw.problems.nine;

import com.zdw.lib.math.Arithmetic;

/**
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * 
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author Zebulun
 *
 */

/*
 * Pythagorean Triples a = m^2-n^2, b = 2mn, c = m^2 + n^2 where m>n
 * Any triple can be multiplied by k {ka, kb, kc} 
 * So 1000 % (a+b+c) == 0 will suffice for finding the correct triple  
 * Since a^2 + b^2 = b^2 + a^2 and a+b = b+a you can just swap a & b at the end.
 * Thus satisfying a < b < c
 */

public class Solution1 {
	public static void main(String[] args) 
	{
		int m = 2;
		int n = 1;
		
		while (!isCorrectSet(m, n)) {
			if (n+1 == m) {
				m++;
				n=1;
			}
			else 
			{
				n++;
			}
		}
	}
	
	public static void print(Object o)
	{
		System.out.println(o);
	}
	
	public static boolean isCorrectSet(int m, int n)
	{
		int a = Arithmetic.square(m) - Arithmetic.square(n);
		int b = 2*m*n;
		int c = Arithmetic.square(m) + Arithmetic.square(n);
	
		if (1000 % (a + b + c) == 0) {
			if (b > a) {
				int temp = a;
				a=b;
				b=temp;
			}
			int factor = 1000 / (a+b+c);
			a*=factor;
			b*=factor;
			c*=factor;
			print("a*b*c=" + (a*b*c));
			return true;
		}
		return false;
	}
}
