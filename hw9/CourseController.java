//Daniel Lee
//Assignment 9

package hw.hw9;
import java.util.*;

public class CourseController implements ControllerObserver, CourseButtonHandler {
	
	public StudentCourseModel model;
	public CourseView cv;
	
	public CourseController(StudentCourseModel model, CourseView cv) {
		this.model = model;
		this.cv = cv;
		model.addObserver(this);
		cv.addButtonController(this);
		getCourseList();
	}
	
	public void add(Course c) {
		model.addCourse(c);
		//System.out.println(model.getCourses());
	}
	
	public Course getCourse(int i) {
		return model.getCourse(i);
	}
	
	public int getIndexSelectedCourse() {
		return cv.getSelectedRow();
	}
	
	public void addNewCourseListener(Course c) {
		model.addCourse(c);
	}
	
	public void update(Student s, Course c) {
		if (s != null) return;
		cv.addRow(c);
	}
	
	private void getCourseList() {
		List<Course> courses = model.getCourseList();
		for (Course c : courses) {
			cv.addRow(c);
		}
	}
	
	public void delete(int i) {
		throw new IllegalArgumentException();
	}
	
	public void changeStudent(List<Course> c) {
		throw new IllegalArgumentException();
	}
}
