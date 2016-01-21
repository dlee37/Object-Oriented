//Daniel Lee
//Assignment 2

package hw.hw2;

public class ComputerPlayer extends Player {
	
	public algorithm a;
	
	public int makeDecision(int currentChips, int DiceAmount) {
		int keepGoing = a.keepGoing();
		return keepGoing;
	}
	
	public int getPotAmt(Pot p) {
		return p.getChips();
	}
	
	public void setAlgorithm() {
		int c = (int) (Math.random());
		switch(c) {
		case 0: a = new algorithm1();
		case 1: a = new algorithm2();
		}
	}
}
