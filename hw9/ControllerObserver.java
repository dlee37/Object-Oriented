//Daniel Lee
//Assignment 9

package hw.hw9;
import java.util.*;

public interface ControllerObserver extends java.io.Serializable {
	
	public void update(Student s, Course c);
	public void delete(int i);
	public void changeStudent(List<Course> c);
}
