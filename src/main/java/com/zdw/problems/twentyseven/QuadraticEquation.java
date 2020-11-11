package com.zdw.problems.twentyseven;

public class QuadraticEquation {
	private int a;
	private int b;
	
	public QuadraticEquation(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculateQuadratic(int n)
	{
		return n*n + a*n + b;
	}
	
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
}
