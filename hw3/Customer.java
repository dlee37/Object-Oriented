//Daniel Lee

package hw.hw3;

public class Customer {
	
	private int arrivalTime;
    private int serviceTime;
    private int items;
    private ItemDistribution i;
    
    public Customer(int t, ItemDistribution i) {
        arrivalTime = t;
        this.i = i;
    }
    
    public void subtractServiceTime() {
        serviceTime--;
    }
    
    public boolean isFinished() {
        return serviceTime == 0;
    }
    
    public int arrivalTime() {
        return arrivalTime;
    }
    
    public void getItems() {
    	items = i.howManyItems();
    }
    
    public void setServiceTime(int i) {
    	serviceTime = i;
    }
    
    public int getServiceTime() {
    	return serviceTime;
    }
    
    public void setItemAmount(int i) {
    	items = i;
    }
    
    public int getItemAmount() {
    	return items;
    }
}
