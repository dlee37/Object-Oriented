//Daniel Lee

package hw.hw4;

public class CurrentConditionsDisplay implements WeatherDisplay {

	private String city;
	private float temp;
	private float humidity;
	private WeatherOutput wo;
	
	public CurrentConditionsDisplay(WeatherData d) {
		d.registerObserver(this);
	}
	
	public void update(WeatherData w) {
		this.city = w.getCity();
		this.temp = w.getTemp();
		this.humidity = w.getHumidity();
		display();
	}
	
	public void display() {
		String s = temp + "F degrees and " + humidity
				+ "% humidity";
		wo.display(s);
	}
	
	public void addWeatherOutput(WeatherOutput wo) {
		this.wo = wo;
	}
}