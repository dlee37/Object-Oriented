//Daniel Lee
//Assignment 10

package hw.hw10;

import java.rmi.Naming;

public class BankClient {
	
	public static void main(String[] args) throws Exception {
		BankView bv  = new BankView();
		BankServiceProxy bs = (BankServiceProxy) Naming.lookup("rmi://localhost/BankService");
		//BankServiceProxy bs = new BankService();
		BankAccountController bac = new BankAccountController(bv);
		BankServiceController bsc = new BankServiceController(bs,bac,bv);
	}
}