//Daniel Lee
//Assignment 9

package hw.hw9;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.*;

public class CourseView extends JFrame {

	private JPanel coursepanel = new JPanel();
	private JButton newcourse = new JButton("NEW COURSE");
	private JTextField code = new JTextField("Course Code", 8);
	private JTextField title = new JTextField("Course Title", 10);
	private JTable coursetable;
	private DefaultTableModel dtm = new DefaultTableModel(0, 0);

	public CourseView() {
		setFrame();
	}

	private void setFrame() {
		setTitle("Course Info");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400, 200);
		String[] header = new String[] { "Course Code", "Course Title" };
		dtm.setColumnIdentifiers(header);
		coursetable = new JTable(dtm);
		coursepanel.add(newcourse);
		coursepanel.add(code);
		coursepanel.add(title);
		Vector columnNames = new Vector<String>();
		columnNames.addElement("Course Number");
		columnNames.addElement("Course Title");
		coursepanel.add(new JScrollPane(coursetable));
		setContentPane(coursepanel);
		setVisible(true);
		pack();
	}

	public void setButtonHandler(CourseButtonHandler bh) {
		newcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CCode = code.getText();
				String CTitle = title.getText();
				Course c = new Course(CCode, CTitle);
				bh.addNewCourseListener(c);
			}
		});
	}

	public void addButtonController(CourseButtonHandler bh) {
		setButtonHandler(bh);
	}

	public int getSelectedRow() {
		return coursetable.getSelectedRow();
	}

	public void addRow(Course c) {
		String code = c.getCourseID();
		String title = c.getCourseName();
		dtm.addRow(new Object[] { code, title });
	}
}