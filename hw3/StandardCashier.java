//Daniel Lee

package hw.hw3;

public class StandardCashier implements Cashier {
	
	public int serviceTime;
	
	public int getServiceTime(Customer c) {
		int time = c.getItemAmount();
		serviceTime = time + 6;
		return serviceTime;
	}
	
	public void elapseOneSecond(Customer c) {
		//makes a cashier implement a standard amount of time
		if (c == null) return;
		c.subtractServiceTime();
	}
}
