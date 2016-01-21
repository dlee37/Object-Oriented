//Daniel Lee

package hw.hw3;

public class FastCashier implements Cashier {
	
	public void elapseOneSecond(Customer c) {
		//does job twice as fast. however, if the customer is done in the
		//half of a second, then the cashier waits until the next second to do the job.
		
		if (c == null) {
			return;
		}
		c.subtractServiceTime();
	}
	
	public int getServiceTime(Customer c) {
		int time = c.getItemAmount();
		//System.out.println(time);
		int serviceTime = (int) (time+6)/2;
		return serviceTime;
	}
}
