//Daniel Lee
//Assignment 5

package hw.hw5;

public class Bearish implements StockAnalyst {
	
	StockInfo s;
	
	public Bearish(StockInfo s) {
		this.s = s;
	}
	
	public String getInfo(String k) {
		return s.get(k);
	}
	
	public float confidenceLevel() {
		return 0.4f;
	}
	
	public String reasons() {
		return "I am pessimistic";
	}
}
