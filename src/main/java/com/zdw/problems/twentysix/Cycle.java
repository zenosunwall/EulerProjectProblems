package com.zdw.problems.twentysix;

public class Cycle {
	CharacterSequence sequence;
	
	private Cycle(CharacterSequence sequence) {
		this.sequence = sequence;
	}
	
	public static Cycle findCycle(char[] input) {
		CharacterSequence sequence = new CharacterSequence();
		for (int i = 0; i < input.length; i++) {
			// Sets up first element of sequence
			if (sequence.isEmpty()) {
				sequence.add(input[i]);
			}
			// if we've found the repeating sequence then we have the cycle
			else if (sequence.isRepeatingSequence(input, i)) break;
			// if we have another instance of the sequence add the next input
			else if (sequence.hasNextSequence(input, i)) sequence.add(input[i]);
			// Else no valid cycle
			else sequence.clear();
		}
		
		return new Cycle(sequence);
	}
	
	public int size() {
		return sequence.size();
	}
	
	public String toString() 
	{
		return sequence.toString();
	}
}
