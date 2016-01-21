//Daniel Lee
package hw.hw6;
import java.util.*;

public class WeatherData {
	
	//keep a list of cities somehow and put this in the WeatherData class. 
	
	private Collection<WeatherDisplay> observers = new ArrayList<WeatherDisplay>();
	private String city;
	private float pressure;
	private float temp;
	private float humidity;
	
	public WeatherData(String city, WeatherMgr mgr) {
		this.city = city;
		mgr.addWeatherData(this);
	}
	
	public void registerObserver(WeatherDisplay obs) {
		observers.add(obs);
	}
	
	public void removeObservers(WeatherDisplay obs) {
		observers.remove(obs);
	}
	
	public void notifyObservers() {
		for (WeatherDisplay wd : observers) {
			//System.out.println("this");
			wd.update(this);
		}
	}
	
	public String getCity() {
		return city;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getTemp() {
		return temp;
	}
	
	public float getPressure() {
		return pressure;
	}
	
	public void updateMeasurement(String c, float p, float t, float h) {
		if (c.equals(this.getCity())){
			pressure = p;
			temp = t;
			humidity = h;
			measurementsChanged();
		}
		//System.out.println("this");
	}
	
	public void measurementsChanged() {
		//System.out.println("this");
		notifyObservers();
	}
}
