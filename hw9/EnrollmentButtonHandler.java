//Daniel Lee
//Assignment 9

package hw.hw9;

import java.util.*;

public interface EnrollmentButtonHandler {
	
	public void addNewEnrollmentListener(Course c);
	public void deleteEnrollmentListener(int c);
	public Course getSelectedCourse();
	public Student getSelectedStudent();
	public List<Course> getCourses();
	public void delete(int i);
	public void updateInfo(Student s);
}
