//Daniel Lee
package hw.hw6;

import java.util.ArrayList;
import java.util.Collection;

public class WeatherMgr {
	
	private static Collection<WeatherData> weather = new ArrayList<WeatherData>();
	
	public void addWeather(String city, float p, float t, float h) {
		for (WeatherData d : weather) {
			d.updateMeasurement(city, p, t, h);
		}
	}
	
	public void deleteObserver(WeatherData d) {
		weather.remove(d);
	}
	
	public void addWeatherData(WeatherData d) {
		weather.add(d);
	}
}