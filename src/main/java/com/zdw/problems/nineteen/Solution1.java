package com.zdw.problems.nineteen;

import com.zdw.lib.math.Arithmetic;

public class Solution1 {
	public static void main(String[] args) {
		int sundays = 0;
		int daysPassed = 1 + 365;
		if (isDivisableBySeven(daysPassed)) {
			daysPassed = 0;
			sundays++;
		}
		for (int year = 1901; year <= 2000; year++) {
			for (Months month : Months.values()) {
				daysPassed += month.getDays();
				if (month == Months.Febuary && isLeapYear(year)) {
					daysPassed++;
				}
				if (isDivisableBySeven(daysPassed)) {
					daysPassed = 0;
					sundays++;
				}
			}
		}
		System.out.println(sundays);
	}

	

	public static boolean isLeapYear(int year) {
		return Arithmetic.divisibleBy(year, 4);
	}

	public static boolean isDivisableBySeven(int day) {
		return Arithmetic.divisibleBy(day, 7);
	}
}
