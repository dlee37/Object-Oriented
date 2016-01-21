//Daniel Lee
//Assignment 5

package hw.hw5;

public class Bullish implements StockAnalyst {
	
	StockInfo s;
	
	public Bullish(StockInfo s) {
		this.s = s;
	}
	
	public float confidenceLevel() {
		return 0.6f;
	}
	
	public String reasons() {
		return "I like taking risks";
	}
	
	public String getInfo(String k) {
		return s.get(k);
	}
}
