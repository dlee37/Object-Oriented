//Daniel Lee
package hw.hw6;

import java.awt.Color;
import java.awt.Component;

import javax.swing.*;
import javax.swing.border.*;

public class FrameInput extends JFrame implements WeatherInput {
	
	public WeatherMgr w = new WeatherMgr();
	public JPanel p1 = new JPanel();
	public JPanel output = new JPanel();
	public JLabel c;
	public JLabel p;
	public JLabel t;
	public JLabel h;
	public JButton btn1;
	public JTextField city;
	public JTextField pressure;
	public JTextField temp;
	public JTextField humidity;
	public JTextArea text;
	public WeatherMgr mgr;
	public ComponentStyler s;
	
	public FrameInput(WeatherMgr mgr, ComponentStyler s) {
		this.mgr = mgr;
		this.s = s;
		
		c = s.createLabel("City: ");
		p = s.createLabel("Pressure: ");
		t = s.createLabel("Temperature: ");
		h = s.createLabel("Humidity: ");
		btn1 = s.createButton("Set Weather");
		city = s.createTextField("", 10);
		pressure = s.createTextField("", 10);
		temp = s.createTextField("", 10);
		humidity = s.createTextField("", 10);
	}
	
	public void run() {
		//runs the input dialog that makes it do everything
		//inputs on a frame
		setFrame();
		setWeatherListener();
		p1.add(c); p1.add(city); p1.add(p); p1.add(pressure);
		p1.add(t); p1.add(temp); p1.add(h); p1.add(humidity);
		add(btn1);
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