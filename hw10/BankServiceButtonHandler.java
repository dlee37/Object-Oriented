//Daniel Lee
//Assignment 10

package hw.hw10;

import java.rmi.RemoteException;

public interface BankServiceButtonHandler {
	
	public void addAccount(String name) throws RemoteException;
	public void getAccount(String name) throws RemoteException;
}