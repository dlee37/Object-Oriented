//Daniel Lee

package hw.hw2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HW2DiceGame {
	private static List<Player> PlayerList = new ArrayList<Player>();
	private static Pot pot = new Pot();
	private static Dice die = new Dice();
	private static boolean gameOver = false;
	private static int playerIndex = 0;

	public static void main(String args[]) {
		String msg = "Welcome to the game! \n " + "What is your name?";
		String name = JOptionPane.showInputDialog(msg);

		msg = "How many other players would you like to play with?";
		String answer = JOptionPane.showInputDialog(msg);
		int numberOfPlayers = Integer.parseInt(answer);

		// create the user and set to index 0
		Player userPlayer = new HumanPlayer(name);
		PlayerList.add(userPlayer);
		
		//set up all of the cpus now
		for (int i = 1; i <= numberOfPlayers; i++) {
			ComputerPlayer c = new ComputerPlayer();
			c.setAlgorithm();
			PlayerList.add(c);
		}
		
		while (!gameOver) {
			Player player = PlayerList.get(playerIndex);

			// winning condition
			if (player.getChips() >= 30) {
				gameOver = true;
				JOptionPane.showMessageDialog(null, player.getName() + " WON!");
				System.exit(0);
			}

			// if first dice
			else if (firstTurn()) {
				oneTurn();
			}
			// get player's decision to bet or not, and process that decision.
			else {
				int option = getChoice();
				processCommand(option);
			}
		}
	}

	private static void processCommand(int cmd) {
		if (cmd == 0) {
			oneTurn();
		} else if (cmd == 1) {
			endTurn();
		} else if (cmd == 2) {
			printStats();
		} else {
			JOptionPane.showMessageDialog(null, "Good bye!");
			System.exit(0);
		}
	}

	private static int getChoice() {
		Player currPlayer = PlayerList.get(playerIndex);
		return currPlayer.makeDecision(pot.getChips(), die.diceNumber());
	}

	private static boolean oneTurn() {
		boolean acedOut = PlayerList.get(playerIndex).doTurn(die, pot);
		if (acedOut) {
			System.out.println(
					"Player " + PlayerList.get(playerIndex).getName() + " aced out after " + (die.diceNumber() - 1) + " rolls ");
			die.resetDiceNumber();
			printStats();
			next();
		} else {
			die.addDie();
		}
		return acedOut;
	}

	private static void next() {
		if (playerIndex == PlayerList.size() - 1)
			playerIndex = 0;
		else
			playerIndex++;
	}
	
	private static void endTurn() {
		System.out.println("Player " + PlayerList.get(playerIndex).getName() + " stopped after " + (die.diceNumber() - 1)
				+ " rolls and won " + pot.getChips() + " chips");
		PlayerList.get(playerIndex).collectChips(die, pot);
		pot.resetPot();
		die.resetDiceNumber();
		printStats();
		next();
	}

	private static void printStats() {
		System.out.print("Chip count: ");
		for (int i = 0; i < PlayerList.size(); i++) {
			System.out.print(PlayerList.get(i).getName() + ": " + PlayerList.get(i).getChips() + "  ");
		}
		System.out.println();
		System.out.println("Pot contains " + pot.getChips() + " chips\n");

	}
	
	private static boolean firstTurn() {
		return die.diceNumber() == 1;
	}
}
