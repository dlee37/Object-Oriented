//Daniel Lee
//Assignment 9

package hw.hw9;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class EnrollmentView extends JFrame {
	
	private JButton add = new JButton("ADD");
	private JButton drop = new JButton("DROP");
	private JButton selectstudent = new JButton("Select Student");
	private JTable enrollment;
	private DefaultTableModel dtm = new DefaultTableModel(0,0);
	private JPanel enrollpanel = new JPanel();
	
	public EnrollmentView() {
		setFrame();
	}
	
	private void setFrame() {
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200,200);
		String[] columnNames = new String[] {"Code","Title"};
		dtm.setColumnIdentifiers(columnNames);
		enrollment = new JTable(dtm);
		enrollpanel.add(add);
		enrollpanel.add(drop);
		enrollpanel.add(selectstudent);
		enrollpanel.add(new JScrollPane(enrollment));
		setContentPane(enrollpanel);
		setVisible(true);
		pack();
	}
	
	public void setButtonHandler(EnrollmentButtonHandler bh) {
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course c = bh.getSelectedCourse();
				bh.addNewEnrollmentListener(c);
			}
		});
		
		drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = enrollment.getSelectedRow();
				bh.deleteEnrollmentListener(i);
			}
		});
		
		selectstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student s = bh.getSelectedStudent();
				setFrameTitle(s);
				bh.updateInfo(s);
				//now find a way to change the table based on the students enrollments
			}
		});
	}
	
	public void setFrameTitle(Student st) {
		String student = st.getStudentName();
		setTitle("Enrollments for " + student);
	}
	
	public void addButtonController(EnrollmentButtonHandler bh) {
		setButtonHandler(bh);
	}
	
	public void addRow(Course c) {
		dtm.addRow(new Object[] {c.getCourseID(), c.getCourseName()});
	}
	
	public void deleteRow(int i) {
		dtm.removeRow(i);
	}
	
	public void makeTable(List<Course> courses) {
		dtm.setRowCount(0);
		for (Course c : courses) {
			dtm.addRow(new Object[] {c.getCourseID(),c.getCourseName()});
		}
	}
}
