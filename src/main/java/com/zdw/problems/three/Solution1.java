package com.zdw.problems.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author Zebulun
 *
 */

public class Solution1 {
	public static void main(String [] args) {
		List<Long> primeNumbers = new ArrayList<>();
		List<Long> factors = new ArrayList<>();
		
		Long testNumber = 600851475143l;
		factors.add(1l);
		factors.add(testNumber);
		
		Long primeNumber = 2l;
		primeNumbers.add(primeNumber);
		if (testNumber % 2 == 0) {
			factors.add(primeNumber);
			factors.add(testNumber / 2);
		}
		
		primeNumbers.add(++primeNumber);
		if (testNumber % primeNumber == 0) {
			factors.add(primeNumber);
			factors.add(testNumber / 3);
		}
		
		do 
		{
			primeNumber = nextPrime(primeNumber, primeNumbers);
			primeNumbers.add(primeNumber);
			if (testNumber % primeNumber == 0) {
				factors.add(primeNumber);
				factors.add(testNumber / primeNumber);
			}
		} while (testNumber / primeNumber > primeNumber);
		
		
		System.out.println(primeNumbers);
		System.out.println(factors);
	}
	
	private static Long nextPrime( Long currentPrime, List<Long> primeNumbers ) {
		Long test = currentPrime + 2l;
		for (Long prime : primeNumbers) {
			if (test % prime == 0) {
				return nextPrime(test, primeNumbers);
			}
		}
		return test;
	}
}
