//Daniel Lee
//Assignment 9

package hw.hw9;

public class Course implements java.io.Serializable {

	private String id;
	private String name;
	
	public Course(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getCourseID() {
		return id;
	}
	
	public String getCourseName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
}
