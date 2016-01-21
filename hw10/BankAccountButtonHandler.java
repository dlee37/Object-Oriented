//Daniel Lee
//Assignment 10

package hw.hw10;

import java.rmi.*;

public interface BankAccountButtonHandler extends Remote {
	
	public void deposit(int amt) throws RemoteException;
	public void withdraw(int amt) throws RemoteException;
	public void showBalance() throws RemoteException;
}
