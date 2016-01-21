//Daniel Lee
//Assignment 10

package hw.hw10;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class BankService extends UnicastRemoteObject implements Serializable, BankServiceProxy {

	private List<BankAccount> accounts = new ArrayList<BankAccount>();

	protected BankService() throws RemoteException {}

	public void addAccount(String name) throws RemoteException {
		BankAccount ba = makeBankAccount(name);
		accounts.add(ba);
	}

	public BankAccountStub getAccount(String name) throws RemoteException {
		for (BankAccountStub ba : accounts) {
			if (ba.getName().equals(name)) {
				return ba;
			}
		}
		
		throw new RemoteException();
	}
	
	public BankAccount makeBankAccount(String name) throws RemoteException {
		return new BankAccount(name);
	}
}
