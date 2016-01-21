//Daniel Lee
//Assignment 9

package hw.hw9;
import java.util.*;

public class EnrollmentController implements ControllerObserver, EnrollmentButtonHandler {
	
	public StudentCourseModel model;
	public EnrollmentView ev;
	public StudentController sc;
	public CourseController cc;
	
	public EnrollmentController(StudentCourseModel model, EnrollmentView ev, 
			StudentController sc, CourseController cc) {
		
		this.model = model;
		this.ev = ev;
		this.sc = sc;
		this.cc = cc;
		model.addObserver(this);
		model.deleteObserver(this);
		model.studentChangeObserver(this);
		ev.addButtonController(this);
	}
	
	public void enrollCourse(Course c) {
		model.enroll(c);
	}
	
	public void addNewEnrollmentListener(Course c) {
		model.enroll(c);
	}
	
	public void update(Student s, Course c) {
		if (s != null && c != null) {
			ev.addRow(c);
		}
	}

	public Course getSelectedCourse() {
		int c = cc.getIndexSelectedCourse();
		return model.getCourse(c);
	}

	public void deleteEnrollmentListener(int c) {
		model.removeCourseFromStudent(c);
	}
	
	public Student getSelectedStudent() {
		int s = sc.getIndexSelectedStudent();
		return model.getStudent(s);
	}
	
	public List<Course> getCourses() {
		return model.getEnrolledCourses();
	}
	
	public void delete(int i) {
		ev.deleteRow(i);
	}
	
	public void changeStudent(List<Course> c) {
		//System.out.println(c);
		ev.makeTable(c);
	}
	
	public void updateInfo(Student s) {
		model.getStudentCourses(s);
	}
}
