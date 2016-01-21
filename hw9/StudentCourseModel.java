//Daniel Lee
//Assignment 9
package hw.hw9;

import java.io.*;
import java.util.*;

public class StudentCourseModel {

	private List<Student> students = new ArrayList<Student>();
	private List<Course> courses = new ArrayList<Course>();
	private Hashtable<Student, List<Course>> enrollments = new Hashtable<Student, List<Course>>();
	private Collection<ControllerObserver> observers = new ArrayList<ControllerObserver>();
	private Collection<ControllerObserver> delete = new ArrayList<ControllerObserver>();
	private Collection<ControllerObserver> studentChange = new ArrayList<ControllerObserver>();
	private Student currentStudent;
	private Course currentCourse;
	private int currentStudentId;

	public StudentCourseModel() throws ClassNotFoundException, IOException {
		File f = new File("output.dat");
		if (f.isFile()) {
			load();
			Student.setId(currentStudentId+1);
		}
	}

	public void addStudent(Student s) {
		students.add(s);
		currentStudentId = s.getId();
		notifyAddObservers(s, null);
		// System.out.println(students);
	}

	public void addCourse(Course c) {
		courses.add(c);
		notifyAddObservers(null, c);
		// System.out.println(courses);
	}

	public Course getCourse(int i) {
		currentCourse = courses.get(i);
		return currentCourse;
	}

	public Student getStudent(int i) {
		currentStudent = students.get(i);
		return currentStudent;
	}

	public void enroll(Course c) {

		if (enrollments.containsKey(currentStudent)) {
			enrollments.get(currentStudent).add(c);
		}

		else {
			ArrayList<Course> StudentCourses = new ArrayList<Course>();
			StudentCourses.add(c);
			enrollments.put(currentStudent, StudentCourses);
		}

		// System.out.println(enrollments);
		notifyAddObservers(currentStudent, c);
	}

	public void removeCourseFromStudent(int i) {
		enrollments.get(currentStudent).remove(i);
		notifyDelete(i);
		// System.out.println(enrollments);
	}

	public void addObserver(ControllerObserver co) {
		observers.add(co);
	}

	public void deleteObserver(ControllerObserver co) {
		delete.add(co);
	}

	public void studentChangeObserver(ControllerObserver co) {
		studentChange.add(co);
	}

	private void notifyAddObservers(Student s, Course c) {
		for (ControllerObserver obs : observers) {
			obs.update(s, c);
		}
	}

	private void notifyDelete(int i) {
		for (ControllerObserver obs : delete) {
			obs.delete(i);
		}
	}

	private void notifyStudentChange(List<Course> c) {
		for (ControllerObserver co : studentChange) {
			co.changeStudent(c);
		}
	}

	public void save() throws IOException, ClassNotFoundException {
		// should save the file here
		OutputStream os = new FileOutputStream("output.dat");
		ObjectOutputStream output = new ObjectOutputStream(os);
		output.writeObject(students);
		output.writeObject(courses);
		output.writeObject(enrollments);
		//System.out.println(currentStudentId);
		output.writeInt(currentStudentId);
		output.close();
	}

	public void load() throws ClassNotFoundException, IOException {
		InputStream is = new FileInputStream("output.dat");
		ObjectInputStream input = new ObjectInputStream(is);
		students = (List<Student>) input.readObject();
		courses = (List<Course>) input.readObject();
		enrollments = (Hashtable<Student, List<Course>>) input.readObject();
		currentStudentId = input.readInt();
	}

	public List<Course> getEnrolledCourses() {
		if (enrollments.contains(currentStudent))
			return enrollments.get(currentStudent);

		else
			return new ArrayList<Course>();
	}

	public List<Course> getCourseList() {
		return courses;
	}

	public List<Student> getStudentList() {
		return students;
	}

	public void getStudentCourses(Student s) {
		if (enrollments.containsKey(s)) {
			List<Course> enrolledCourses = enrollments.get(s);
			// System.out.print(enrolledCourses);
			notifyStudentChange(enrolledCourses);
		}

		else {
			// System.out.println("Hello World!");
			notifyStudentChange(new ArrayList<Course>());
		}
	}
}