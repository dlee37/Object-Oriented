//Daniel Lee
//Assignment 2

package hw.hw2;

public class algorithm1 extends algorithm {
	
	public Pot pot = new Pot();
	
	public int keepGoing() {
	    if (c.getPotAmt(pot) > 3) {
	        return 1;
	    }
	    
	    else {
	        return 0;
	    }
	}
}