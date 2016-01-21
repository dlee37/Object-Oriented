package hw.hw6;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ComponentStyler {
	
	private JButton j;
	private JLabel l;
	private JTextField f;
	private JTextArea a;
	private Color x;
	private Color y;
	private Border b;
	
	public ComponentStyler(Color x, Color y) {
		this.x = x;
		this.y = y;
		b = BorderFactory.createLineBorder(x,3);
		
	}
	
	public JButton createButton(String s) {
		
		j = new JButton(s);
		j.setBorder(b);
		j.setBackground(y);
		return j;
	}
	
	public JLabel createLabel(String s) {
		
		l = new JLabel(s);
		l.setForeground(y);
		return l;
	}
	
	public JTextField createTextField(String s, int size) {
		
		f = new JTextField(s,size);
		f.setBorder(b);
		f.setBackground(y);
		return f;
	}
	
	public JTextArea createTextArea(int w, int h) {
		
		a = new JTextArea(w,h);
		a.setBorder(b);
		a.setBackground(y);
		return a;
	}
}
