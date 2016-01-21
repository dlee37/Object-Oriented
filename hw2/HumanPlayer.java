//Daniel Lee

package hw.hw2;

import javax.swing.JOptionPane;

public class HumanPlayer extends Player {
	
	public HumanPlayer(String n) {
		super();
		setName(n);
	}

	public int makeDecision(int currPot, int currDice) {
		String msg = "It iss your turn, " + getName() + "!\nChips Owned " + getChips()
				+ "\nAmount of Dice to Roll: " + currPot + "\nChips in Pot: " + currDice + 
				"\n Type y to continue, n to stop your turn, or any other key to view stats";
		
		String ans = JOptionPane.showInputDialog(msg);
		if (ans.equals("y")) {
			return 0;
		}
		
		else if (ans.equals("n")) {
			return 1;
		}
		
		else {
			return 2;
		}
	}
}
