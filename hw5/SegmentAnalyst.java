//Daniel Lee
//Assignment 5

package hw.hw5;

public class SegmentAnalyst extends AnalystDecorator {
	
	private float autoStocks = 0.2f;
	private float techStocks = 0.8f;
	public StockAnalyst a;
	public StockInfo s;
	
	public SegmentAnalyst(StockAnalyst a) {
		super(a);
	}
	
	public float confidenceLevel() {
		if (getAnalyst().getInfo("marketsegment").equals("technology")) {
			return ((techStocks + getAnalyst().confidenceLevel())/2);
		}
		else if (getAnalyst().getInfo("marketsegment").equals("auto")) {
			return ((autoStocks + getAnalyst().confidenceLevel())/2);
		}
		
		return getAnalyst().confidenceLevel();
	}
	
	public String reasons() {
		return getAnalyst().reasons() + ", but I know technology and auto stocks";
	}
}
