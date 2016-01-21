//Daniel Lee
//Assignment 5

package hw.hw5;

public abstract class AnalystDecorator implements StockAnalyst {
	
	StockAnalyst a;
	
	public AnalystDecorator(StockAnalyst a) {
		this.a = a;
	}
	
	public abstract float confidenceLevel();
	
	public abstract String reasons();
	
	public StockAnalyst getAnalyst() {
		return a;
	}
	
	public String getInfo(String s) {
		return getAnalyst().getInfo(s);
	}
}
