//Daniel Lee
package hw.hw4;

public class StatisticsDisplay implements WeatherDisplay {
	
	private String city;
	private float maxTemp;
	private float minTemp = 500f;
	private float tempSum = 0.0f;
	private int numReadings;
	private WeatherOutput wo;

	public StatisticsDisplay(WeatherData d) {
		city = d.getCity();
		//System.out.println(minTemp);
		d.registerObserver(this);
	}
	
	public void update(WeatherData w) {
		float temp = w.getTemp();
		//System.out.println(temp);
		tempSum += temp;
		numReadings++;
		if (temp > maxTemp) maxTemp = temp;
		if (temp < minTemp) minTemp = temp;
		display();
	}
	
	public void display() {
		//displays the output of all of the outputs
		String s = "Avg/Max/Min temperature: " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp;
		wo.display(s);
	}
	
	public void addWeatherOutput(WeatherOutput wo) {
		this.wo = wo;
	}
}