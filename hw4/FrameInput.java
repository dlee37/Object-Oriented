//Daniel Lee
package hw.hw4;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.*;

public class FrameInput extends JFrame implements WeatherInput {
	
	public JPanel p1 = new JPanel();
	public JPanel output = new JPanel();
	public JLabel c = new JLabel("City");
	public JLabel p = new JLabel("Pressure: ");
	public JLabel t = new JLabel("Temperature: ");
	public JLabel h = new JLabel("Humidity: ");
	public JButton btn1 = new JButton("Set Weather");
	public JTextField city = new JTextField("",10); 
	public JTextField pressure = new JTextField("", 10);
	public JTextField temp = new JTextField("", 10);
	public JTextField humidity = new JTextField("", 10);
	public WeatherMgr w = new WeatherMgr();
	public JTextArea text = new JTextArea();
	public WeatherMgr mgr;
	
	public FrameInput(WeatherMgr mgr) {
		this.mgr = mgr;
	}
	
	public void run() {
		//runs the input dialog that makes it do everything
		//inputs on a frame
		setFrame();
		setWeatherListener();
		p1.add(c); p1.add(city); p1.add(p); p1.add(pressure);
		p1.add(t); p1.add(temp); p1.add(h); p1.add(humidity);
		p1.setBorder(new LineBorder(Color.red));
		output.add(text);
		add(output); add(btn1);
		pack();
	}
	
	private void setFrame() {
		setTitle("FrameInput");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200,200);
		setContentPane(p1);
		setVisible(true);
	}
	
	public void setWeatherListener() {
		btn1.addActionListener(evt -> {
			String newCity = city.getText();
			String newPressure = pressure.getText();
			String newTemp = temp.getText();
			String newHumidity = humidity.getText();
			mgr.addWeather(newCity, setFloat(newPressure), setFloat(newTemp), setFloat(newHumidity));
		});
	}
	
	private static float setFloat(String str) {
		return Float.parseFloat(str);
	}
}