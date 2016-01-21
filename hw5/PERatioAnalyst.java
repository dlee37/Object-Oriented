//Daniel Lee
//Assignment 5

package hw.hw5;

public class PERatioAnalyst extends AnalystDecorator {

	public PERatioAnalyst(StockAnalyst a) {
		super(a);
	}

	public float confidenceLevel() {

		float PERatio = getPER();
		if (PERatio < 9) {
			return ((0.7f + getAnalyst().confidenceLevel()) / 2);
		} else if (PERatio > 9 && PERatio < 20) {
			return ((0.5f + getAnalyst().confidenceLevel()) / 2);
		} else {
			return ((0.3f + getAnalyst().confidenceLevel()) / 2);
		}
	}

	private float getPER() {
		float currentPrice = Float.parseFloat(getInfo("shareprice"));
		float currentEarnings = Float.parseFloat(getInfo("earnings"));

		return currentPrice / currentEarnings;
	}

	public String reasons() {
		return getAnalyst().reasons() + ", based on the Price and Earnings Ratio";
	}
}
