//Daniel Lee
//Assignment 10

package hw.hw10;

import java.rmi.RemoteException;

public class BankServiceController implements BankServiceButtonHandler {
	
	private BankServiceProxy bsp;
	private BankView bv;
	private BankAccountController bac;
	private BankAccountStub currentAccount;
	
	public BankServiceController(BankServiceProxy bsp, BankAccountController bac, BankView bv) {
		this.bsp = bsp;
		this.bv = bv;
		this.bac = bac;
		bv.setButtonHandler(this);
	}

	public void addAccount(String name) throws RemoteException {
		bsp.addAccount(name);
		currentAccount = bsp.getAccount(name);
		bac.setCustomer(currentAccount);
	}

	public void getAccount(String name) throws RemoteException {
		currentAccount = bsp.getAccount(name);
		bac.setCustomer(currentAccount);
		
	}
	
	public String getCurrentUser() throws RemoteException {
		return currentAccount.getName();
	}
}
