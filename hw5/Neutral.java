//Daniel Lee
//Assignment 5

package hw.hw5;

public class Neutral implements StockAnalyst {
	
	StockInfo s;
	
	public Neutral(StockInfo s) {
		this.s = s;
	}
	
	public float confidenceLevel() {
		return 0.5f;
	}
	
	public String reasons() {
		return "I am unbiased in my decisions";
	}
	
	public String getInfo(String k) {
		return s.get(k);
	}
}
