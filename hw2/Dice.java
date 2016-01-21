//Daniel Lee

package hw.hw2;

import java.util.Random;

public class Dice {
	private int numDice = 1;
	
	public Dice() {
		this.numDice = numDice;
	}
	
	public void addDie() {
		numDice++;
	}
	
	public void resetDiceNumber() {
		numDice = 1;
	}

	public int diceNumber() {
		return numDice;
	}
	
	public boolean rollToAceOut() {
		for (int i = 0; i < numDice; i++) {
			Random rd = new Random();
			// randomize from 1 ~ 4
			int rand = 1 + rd.nextInt(4);
			if (rand == 1)
				return true;
		}
		return false;
	}
}
