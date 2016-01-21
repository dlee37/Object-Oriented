//Daniel Lee
//Assignment 9

package hw.hw9;

import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class FileView extends JFrame {
	
	private JButton SaveExit = new JButton("SAVE AND EXIT");
	private JPanel panel = new JPanel();
	private FileController fc;
	
	public FileView() {
		setFrame();
	}
	
	private void setFrame() {
		setTitle("Course Info");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400,200);
		//add the save function in the button
		panel.add(SaveExit);
		SaveExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fc.save();
					System.exit(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setVisible(true);
		setContentPane(panel);
		pack();
	}
	
	public void addController(FileController fc) {
		this.fc = fc;
	}
}