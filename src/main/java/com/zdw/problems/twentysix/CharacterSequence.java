package com.zdw.problems.twentysix;

import java.util.ArrayList;
import java.util.List;

public class CharacterSequence {
	private List<Character> sequence = new ArrayList<>();
	
	public boolean isSequenceAt(char[] input, int beginIndex)
	{
		for (int i = 0; i < sequence.size(); i++)
		{
			if (sequence.get(i) != input[i + beginIndex]) return false;
		}
		return true;
	}
	
	public boolean hasNextSequence(char[] input, int beginIndex)
	{
		for (int i = beginIndex; i < input.length - sequence.size(); i++)
		{
			if (isSequenceAt(input, i)) return true;
		}
		return false;
	}
	
	public boolean isRepeatingSequence(char[] input, int beginIndex)
	{
		for (int i = beginIndex; i < input.length - sequence.size(); i+=sequence.size())
		{
			if (!isSequenceAt(input, i)) return false; 
		}
		return true;
	}
	
	public boolean isEmpty()
	{
		return sequence.isEmpty();
	}
	
	public void clear()
	{
		sequence.clear();
	}
	
	public void add(Character c)
	{
		sequence.add(c);
	}
	
	public int size() 
	{
		return sequence.size();
	}
	
	public String toString()
	{
		return sequence.toString();
	}
}
