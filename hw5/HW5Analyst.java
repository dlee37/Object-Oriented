//Daniel Lee
//Assignment 5

package hw.hw5;

public class HW5Analyst {
	
	public static void main(String[] args) {
		StockInfo s = new StockInfo("appleInfo.txt");
		StockAnalyst a = new Bullish(s);
		StockAnalyst b = new PERatioAnalyst(a);
		StockAnalyst c = new SegmentAnalyst(b);
		System.out.println(b.confidenceLevel());
		System.out.println(b.reasons());
		System.out.println(c.confidenceLevel());
		System.out.println(c.reasons());
		StockAnalyst d = new SegmentAnalyst(c);
		System.out.println(d.confidenceLevel());
		System.out.println(d.reasons());
		StockAnalyst e = new PERatioAnalyst(d);
		System.out.println(e.confidenceLevel());
		System.out.println(e.reasons());
	}
}
