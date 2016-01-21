//Daniel Lee
package hw.hw4;

import java.util.List;
import javax.swing.*;

public class FrameOutput extends JFrame implements WeatherOutput {
	
	private JPanel panel = new JPanel();
	private JTextArea text = new JTextArea(30,50);
	private String city;
	
	public FrameOutput(List<WeatherDisplay> d, String city) {
		for (WeatherDisplay wo : d) {
			wo.addWeatherOutput(this);
		}
		this.city = city;
		setFrame();
		pack();
		panel.add(text);
	}
	
	public void display(String s) {
		text.append("\n"+s);
	}
	
	private void setFrame() {
		setTitle(city);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200,200);
		setContentPane(panel);
		panel.add(text);
		setVisible(true);
	}
}
