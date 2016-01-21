//Daniel Lee
package hw.hw6;

public class ForecastDisplay implements WeatherDisplay {
	
	private String city;
	private float currentPressure;
	private float oldPressure;
	private WeatherOutput wo;
	
	public ForecastDisplay(WeatherData w) {
		w.registerObserver(this);
		city = w.getCity();
	}
	
	public void update(WeatherData w) {
		oldPressure = currentPressure;
		currentPressure = w.getPressure();
		display();
		//use .replace to change the value of the hashtable
	}
	
	public void display() {
		//prints out a display forecast on a swing pane
		System.out.print("Forecast: ");
		String s;
		if (currentPressure > oldPressure)
			s = "Improving weather on the way!";
		else if (currentPressure == oldPressure)
			s = "More of the same";
	    else
	    	s = "Watch out for cooler, rainy weather";
		
		wo.display(s);
	}
	
	public void addWeatherOutput(WeatherOutput wo) {
		this.wo = wo;
	}
}
