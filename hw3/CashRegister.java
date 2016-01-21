//Daniel Lee

package hw.hw3;
import java.util.*;

public class CashRegister {
	
	//each cash register is going to have a fast or a standard cash register
	
	//public static int CashRegisterNumber = 0;
	private List<Customer> custs = new LinkedList<Customer>();
    private int numServed = 0;
    private int totalWaitTime = 0;
    private Customer currentCust = null;
    private Cashier cashier;
    public ItemDistribution dist;;
    
    public CashRegister(Cashier cashier, ItemDistribution dist) {
    	this.cashier = cashier;
    	this.dist = dist;
    }
    
    public void addCustomer(int t, ItemDistribution dist) {
        Customer c = new Customer(t, dist);
        custs.add(c);
        c.setItemAmount(dist.howManyItems());
        //System.out.println(c.getItemAmount());
        c.setServiceTime(cashier.getServiceTime(c));
        if (currentCust == null) {
            currentCust = c;
        }
    }
    
    public void elapseOneSecond(int currentTime) {
        // Return if there is no current customer.
        if (currentCust == null)
            return;
        currentCust.subtractServiceTime();
        //this elapses one second based on the type of cashier
        // Otherwise, process the current customer.
        //System.out.println(currentCust.isFinished());
        if (currentCust.isFinished()) {
        	//System.out.println("yes");
            numServed++;
            totalWaitTime += currentTime - currentCust.arrivalTime();
            //System.out.println(totalWaitTime);
            // Remove the finished customer and make the next customer current.
            custs.remove(0);
            currentCust = custs.size() > 0 ? custs.get(0) : null;
        }
    }
    
    public int size() { 
        return custs.size(); 
    }
    
    public int customersServed() { 
        return numServed; 
    }
    
    public int avgWaitTime() { 
    	//System.out.println(totalWaitTime/numServed);
    	if (numServed == 0) return 0;
    	//System.out.println(totalWaitTime);
    	//System.out.println(numServed);
        return totalWaitTime / numServed; 
    }
    
    public int getCurrentLineLength() {
    	return custs.size();
    }
    
    public int getServiceTime() {
    	//System.out.println("this");
    	return cashier.getServiceTime(currentCust);
    }
}
