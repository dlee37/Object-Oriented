//Daniel Lee

package hw.hw2;

public abstract class Player {
	private static int nextPlayer = 0;
	private int chips, number;
	private String name;

	public Player() {
		number = nextPlayer;
		nextPlayer++;
		chips = 0;
	}

	public void setName(String n) {
		name = n;
	}

	public int getChips() {
		return chips;
	}
	
	public int getNumber() {
		return number;
	}

	public void collectChips(Dice dice, Pot pot) {
		chips += pot.getChips();
	}

	public String getName() {
		return name;
	}
	
	public boolean doTurn(Dice dice, Pot pot) {
		// player adds chips equivalent to the number of dices into the pot.
		// player then rolls the dice.
		pot.addAmount(dice.diceNumber());
		boolean acedOut = dice.rollToAceOut();
		return acedOut;
	}
	
	abstract int makeDecision(int currPot, int currDice);

}