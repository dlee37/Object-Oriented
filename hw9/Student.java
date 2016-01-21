//Daniel Lee
//Assignment 9

package hw.hw9;

public class Student implements java.io.Serializable {
	
	private static int idnum = 1;
	public int id;
	public String name;
	public String year;
	
	public Student(String name, String year) {
		this.name = name;
		this.year = year;
		id = idnum;
		idnum++;
	}
	
	public String getStudentName() {
		return name;
	}
	
	public String getGradYear() {
		return year;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return name;
	}
	
	public static void setId(int i) {
		idnum = i;
	}
}