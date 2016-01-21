//Daniel Lee
//Assignment 10

package hw.hw10;
import java.rmi.*;
import java.util.*;

public interface BankServiceProxy extends Remote {
	
	public void addAccount(String name) throws RemoteException;
	public BankAccountStub getAccount(String name) throws RemoteException;
	public BankAccountStub makeBankAccount(String name) throws RemoteException;
}
