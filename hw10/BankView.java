//Daniel Lee
//Assignment 10

package hw.hw10;

import java.awt.event.*;
import java.rmi.RemoteException;
import javax.swing.*;

public class BankView extends JFrame {
	
	private JPanel panel = new JPanel();
	private JLabel user = new JLabel("UserName");
	private JLabel amt = new JLabel("Amount");
	private JTextField username = new JTextField("",10);
	private JButton newAccount = new JButton("New Account");
	private JButton getAccount = new JButton("Get Account");
	private JTextField amount = new JTextField("",10);
	private JButton deposit = new JButton("Deposit");
	private JButton withdraw = new JButton("Withdraw");
	private JButton showbalance = new JButton("Show Balance");
	private JTextArea balance = new JTextArea(1,8);
	
	public BankView() {
		setFrame();
	}
	
	public void setButtonHandler(BankServiceButtonHandler bh) {
		newAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = username.getText();
				try {
					bh.addAccount(name);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		getAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = username.getText();
				try {
					bh.getAccount(name);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void setButtonHandler(BankAccountButtonHandler bh) {
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = amount.getText();
				int a = Integer.parseInt(t);
				try {
					bh.deposit(a);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = amount.getText();
				int a = Integer.parseInt(t);
				try {
					bh.withdraw(a);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		showbalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bh.showBalance();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	private void setFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.add(user);
		panel.add(username);
		panel.add(newAccount);
		panel.add(getAccount);
		panel.add(amt);
		panel.add(amount);
		panel.add(deposit);
		panel.add(withdraw);
		panel.add(showbalance);
		panel.add(balance);
		setContentPane(panel);
		setVisible(true);
		pack();
	}
	
	public void addButtonController(BankAccountButtonHandler bh) {
		setButtonHandler(bh);
	}
	
	public void addButtonController(BankServiceButtonHandler bh) {
		setButtonHandler(bh);
	}
	
	public void showBalance(int money) {
		String m = Integer.toString(money);
		balance.setText("");
		balance.append("$" + m);
	}
}