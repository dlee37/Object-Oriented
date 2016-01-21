//Daniel Lee

package hw.hw4;
import java.util.List;

public class ConsoleOutput implements WeatherOutput {
	
	public String city;

	public ConsoleOutput(List<WeatherDisplay> d, String city) {
		for (WeatherDisplay wo : d) {
			wo.addWeatherOutput(this);
			this.city = city;
		}
	}
	
	public void display(String s) {
		System.out.println(city);
		System.out.println(s);
	}
}
