//Daniel Lee
//Assignment 2


package hw.hw2;

public class algorithm2 extends algorithm {
	
	public Pot pot = new Pot();
	public algorithm2() {
		super();
	}
	
	public int keepGoing() {
		if (c.getPotAmt(pot) <= 20) {
			return 1;
		}
		return 0;
	}
}
