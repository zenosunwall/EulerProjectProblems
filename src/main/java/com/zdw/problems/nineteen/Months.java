package com.zdw.problems.nineteen;

public enum Months {
	January(31), Febuary(28), March(31), April(30), May(31), June(30), July(31), August(31), September(30), October(31), November(30), December(31);
	int days;
	Months(int days)
	{
		this.days = days;
	}
	
	public int getDays()
	{
		return days;
	}
}