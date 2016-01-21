//Daniel Lee

package hw.hw4;

import java.util.Scanner;

public class ConsoleInput implements WeatherInput {

	private WeatherMgr mgr;

	public ConsoleInput(WeatherMgr mgr) {
		this.mgr = mgr;
	}
	
	public void run() {
		while (true) {
			System.out.print("Type q anytime to stop. City: ");
			Scanner sc = new Scanner(System.in);
			String city = sc.nextLine();
			if (breakLoop(city)) break;
			System.out.print("Pressure: ");
			float pressure = sc.nextFloat();
			System.out.print("Tempurature: ");
			float temp = sc.nextFloat();
			System.out.print("Humidity: ");
			float humidity = sc.nextFloat();
			mgr.addWeather(city, pressure, temp, humidity);
			
			//System.out.println("this");
			// s.update(data);
		}
	}
	
	public static boolean breakLoop(String s) {
		if (s.equals("q")) return true;
		return false;
	}
}