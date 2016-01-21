//Daniel Lee
//Assignment 5

package hw.hw5;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BorderTest extends JFrame {
	
	JFrame frame1 = new JFrame(); JFrame frame2 = new JFrame(); JFrame frame3 = new JFrame();
	JFrame frame4 = new JFrame();
	
	JPanel panel1 = new JPanel(); JPanel panel2 = new JPanel(); JPanel panel3 = new JPanel(); 
	JPanel panel4 = new JPanel();
	
	JTextField text1 = new JTextField("your message here", 30);
	JTextField text2 = new JTextField("your message here", 30);
	JTextField text3 = new JTextField("your message here", 30);
	JTextField text4 = new JTextField("your message here", 30);
	
	Border blueBorder = new LineBorder(Color.blue,5);
	Border redBorder = new LineBorder(Color.red,5);
	Border greenBorder = new LineBorder(Color.green,5);
	
	public void make2Border() {
		make1stFrame();
		panel1.add(text1);
		Border together = new CompoundBorder(redBorder, greenBorder);
		text1.setBorder(together);
		frame1.pack();
	}
	
	public void make3Border() {
		make2ndFrame();
		Border together = new CompoundBorder(redBorder, greenBorder);
		Border threeColors = new CompoundBorder(together, blueBorder);
		text2.setBorder(threeColors);
		panel2.add(text2);
		frame2.pack();
	}
	
	public void makeABorderTitle() {
		make3rdFrame();
		Border title = new TitledBorder(greenBorder, "A title");
		Border compound = new CompoundBorder(title, redBorder);
		text3.setBorder(compound);
		panel3.add(text3);
		frame3.pack();
	}
	
	public void make2TitleBorder() {
		make4thFrame();
		Border compound = new CompoundBorder(redBorder, greenBorder);
		Border title = new TitledBorder(compound, "A title");
		text4.setBorder(title);
		panel4.add(text4);
		frame4.pack();
	}
	
	public void make1stFrame() {
		frame1.setTitle("2 Borders");
		frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame1.setLocation(200,200);
		frame1.setContentPane(panel1);
		frame1.setVisible(true);
	}
	
	public void make2ndFrame() {
		frame2.setTitle("3 borders");
		frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame2.setLocation(400,200);
		frame2.setContentPane(panel2);
		frame2.setVisible(true);
	}
	
	public void make3rdFrame() {
		frame3.setTitle("Title on one Border");
		frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame3.setLocation(200,300);
		frame3.setContentPane(panel3);
		frame3.setVisible(true);
	}
	
	public void make4thFrame() {
		frame4.setTitle("Title on Both Borders");
		frame4.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame4.setLocation(200,400);
		frame4.setContentPane(panel4);
		frame4.setVisible(true);
	}
	
	public static void main(String[] args) {
		BorderTest t = new BorderTest();
		t.make2Border();
		t.make3Border();
		t.makeABorderTitle();
		t.make2TitleBorder();
	}
}
