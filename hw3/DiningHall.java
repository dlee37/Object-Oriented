//Daniel Lee

package hw.hw3;
import java.util.*;

public class DiningHall {
	
	private static final int CUST_ARRIVAL_PCT = 80; //change to 19 when done
	public static List<CashRegister> CashRegisters = new ArrayList<CashRegister>();
	public static ItemDistribution dist;
	public int standard;
	public int fast;
	//dining hall will add customers based on the cashier that is mainly open.
	
	public DiningHall(int standard, int fast, ItemDistribution dist) {
		this.standard = standard;
		this.fast = fast;
		this.dist = dist;
	}
	
	public void printStats() {
		int size = CashRegisters.size();
		for (int i = 0; i < size; i++) {
			CashRegister reg = CashRegisters.get(i);
			System.out.println("Register " + i);
			System.out.println("\tNumber of arrivals = " + reg.customersServed());
			System.out.println("\tAverage wait time = " + reg.avgWaitTime());
		}
	}
	
	public void setCashRegisters() {
		/*can put "express" lanes together and the reset standard */
		
		for (int i = 0; i < fast; i++) {
			CashRegister reg = new CashRegister(new FastCashier(), dist);
			CashRegisters.add(reg);
			
		}
		
		for (int j = 0; j < standard; j++) {
			CashRegister reg = new CashRegister(new StandardCashier(), dist);
			CashRegisters.add(reg);
		}
	}
	
	public static boolean aCustomerArrives() { //delete static after test
		int n = (int) (Math.random() * 100);  // an integer between 0 and 99
		return n < CUST_ARRIVAL_PCT;
	}
	
	public void elapseOneSecond(int t) {
		int cashierAmount = CashRegisters.size();
		if (aCustomerArrives()) {
			//System.out.println("this");
			CashRegister reg = CashRegisters.get(0);
			for (int i = 1; i < cashierAmount; i++) {
				if (reg.getCurrentLineLength() > CashRegisters.get(i).
						getCurrentLineLength()) {
					
					reg = CashRegisters.get(i);
				}
			}
			reg.addCustomer(t, dist);
			//System.out.println(reg);
		}
			
		for (int i = 0; i < cashierAmount; i++) {
			CashRegisters.get(i).elapseOneSecond(t);
		}
	}
}