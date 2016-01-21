//Daniel Lee

package hw.hw3;

public class Uniform implements ItemDistribution {
	
	public int howMuchTime;
	public int maxItems;
	
	public Uniform(int maxItems) {
		this.maxItems = maxItems;
	}
	
	public int howManyItems() {
		int i = maxItems;
		int item = (int) (Math.random() * i);
		return item;
	}
	
	public String toString() {
		/* Have toString methods to see if the program was implementing the 
		 correct distribution */
		
		return "Uniform";
	}
}
