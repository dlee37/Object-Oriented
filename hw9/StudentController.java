//Daniel Lee
//Assignment 9

package hw.hw9;
import java.util.*;

public class StudentController implements ControllerObserver, StudentButtonHandler {
	
	public StudentCourseModel model;
	public StudentView sv;
	
	public StudentController(StudentCourseModel model, StudentView sv) {
		this.model = model;
		this.sv = sv;
		model.addObserver(this);
		sv.addButtonController(this);
		getStudentList();
	}
	
	public void add(Student s) {
		model.addStudent(s);
		//System.out.println(model.getStudents());
	}
	
	public void update(Student s, Course c) {
		if (c != null) return;
		sv.addRow(s);
	}
	
	public int getIndexSelectedStudent() {
		return sv.getSelectedRow();
	}
	
	public void addNewStudentListener(Student s) {
		model.addStudent(s);
	}

	public Student getCurrentStudent() {
		int i = sv.getSelectedRow();
		return model.getStudent(i);
	}
	
	private void getStudentList() {
		List<Student> students = model.getStudentList();
		for (Student s : students) {
			sv.addRow(s);
		}
	}
	
	public void delete(int i) {
		throw new IllegalArgumentException();
	}
	
	public void changeStudent(List c) {
		throw new IllegalArgumentException();
	}
}
