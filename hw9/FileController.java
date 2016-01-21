//Daniel Lee
//Assignment 9

package hw.hw9;
import java.io.IOException;

public class FileController {

	public StudentCourseModel model;
	public FileView fv;
	
	public FileController(StudentCourseModel model, FileView fv) {
		this.model = model;
		this.fv = fv;
		fv.addController(this);
	}
	
	public void save() throws ClassNotFoundException, IOException {
		model.save();
	}
	
	
}
