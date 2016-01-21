//Daniel Lee
//Assignment 9
package hw.hw9;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class StudentView extends JFrame {
	
	private JPanel panel = new JPanel();
	private JButton newstudent = new JButton("NEW STUDENT");
	private JTextField name = new JTextField("Student Name",10);
	private JTextField grad = new JTextField("Grad",5);
	DefaultTableModel dtm = new DefaultTableModel(0,0);
	private JTable students;
	
	public StudentView() {
		setFrame();
	}
	
	private void setFrame() {
		setTitle("Students");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400,200);
		String[] columnNames = new String[] {"Id","Name","GradYear"};
		dtm.setColumnIdentifiers(columnNames);
		students = new JTable(dtm);
		panel.add(newstudent);
		panel.add(name);
		panel.add(grad);
		panel.add(new JScrollPane(students));
		setContentPane(panel);
		setVisible(true);
		pack();
	}
	
	public void setButtonHandler(StudentButtonHandler bh) {
		newstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String StudentName = name.getText();
				String StudentGrad = grad.getText();
				Student s = new Student(StudentName, StudentGrad);
				bh.addNewStudentListener(s);
			}
		});
	}
	
	public void addButtonController(StudentButtonHandler bh) {
		setButtonHandler(bh);
	}
	
	public int getSelectedRow() {
		return students.getSelectedRow();
	}
	
	public void addRow(Student s) {
		String id = Integer.toString(s.getId());
		String name = s.getStudentName();
		String grad = s.getGradYear();
		dtm.addRow(new Object[] {id,name,grad});
	}
}
