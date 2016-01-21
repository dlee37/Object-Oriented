//Daniel Lee

package hw.hw2;

public class Pot {
	private int potMoney = 0;

	public void addAmount(int amt) {
		potMoney += amt;
	}

	public int getChips() {
		return potMoney;
	}

	public void resetPot() {
		potMoney = 0;
	}
}