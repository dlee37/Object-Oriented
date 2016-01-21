//Daniel Lee

package hw.hw3;

public class Bimodal implements ItemDistribution {
	
	public int maxItems;

	public Bimodal(int maxItems) {
		this.maxItems = maxItems;
	}
	
	public int howManyItems() { //this implements a bimodal distribution

		int firstBound = (maxItems/4);
		int secondBound = (3*maxItems)/4;

		int lowerBound = (int) (Math.random() * firstBound);
		// System.out.println(lowerBound);
		int upperBound = secondBound + (int) (Math.random() * (maxItems - secondBound));
		// System.out.println(upperBound);

		int choose = (int) (Math.random() * 3);
		// System.out.println(choose);

		if (choose < 2) {
			if (lowerBound == 0) {
				lowerBound++; //forces people at cash register to have an item
			}
			return lowerBound;
		}

		else {
			return upperBound;
		}
	}
}
