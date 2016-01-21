//Daniel Lee
//Assignment 10

package hw.hw10;

import java.rmi.RemoteException;

public class BankAccountController implements BankAccountButtonHandler {
	
	public BankAccountStub ba;
	public BankView bv;
	
	public BankAccountController(BankView bv) throws RemoteException {
		this.bv = bv;
		bv.setButtonHandler(this);
	}
	
	public void deposit(int amt) throws RemoteException {
		ba.deposit(amt);
	}
	
	public void withdraw(int amt) throws RemoteException {
		ba.withdraw(amt);
	}
	
	public void showBalance() throws RemoteException {
		//System.out.println("Hello");
		int amt = ba.getBalance();
		bv.showBalance(amt);
	}
	
	public void setCustomer(BankAccountStub bas) {
		ba = bas;
	}
}