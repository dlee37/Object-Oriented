//Daniel Lee
//Assignment 10

package hw.hw10;

import java.rmi.*;
import java.rmi.registry.*;

public class StartBankRemote {

	public static void main(String[] args) throws Exception {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
		}

		catch (RemoteException e) {
			
		}

		BankServiceProxy bs = new BankService();
		Naming.rebind("rmi://localhost/BankService", bs);
	}
	/*
	 * try { Registry r = LocateRegistry.createRegistry(1098); }
	 * 
	 * catch (RemoteException e) { }
	 * 
	 * BankAccount ba = new BankAccount(bs);
	 * Naming.rebind("rmi://localhost/BankAccount", ba); }
	 */
}