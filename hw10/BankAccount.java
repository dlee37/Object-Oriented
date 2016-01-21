//Daniel Lee
//Assignment 10

package hw.hw10;

import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class BankAccount extends UnicastRemoteObject implements Serializable, BankAccountStub {
	
	private int total = 0;
	private String name;
	
	public BankAccount(String name) throws RemoteException {
		this.name = name;
	}
	
	public void deposit(int amt) throws RemoteException {
		//System.out.println("Hello");
		total += amt;
	}
	
	public void withdraw(int amt) throws RemoteException {
		if (total > amt) total -= amt;
	}
	
	public int getBalance() throws RemoteException {
		return total;
	}
	
	public String getName() throws RemoteException {
		return name;
	}
}