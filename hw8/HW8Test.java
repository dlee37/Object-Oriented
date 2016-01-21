package hw.hw8;

import java.io.*;
import java.util.*;

public class HW8Test {
	private static List<List<String>> allrows = new ArrayList<List<String>>();

	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner("v1,\"v \"\"2\"\", perhaps\",v3");
		Scanner sc = new Scanner(new FileInputStream("text.csv"));
		//Scanner sc = new Scanner("\"Hello\", \"World\"");
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			processLine(line);
		}
		sc.close();
		for (List<String> row : allrows) {
			for (String value : row)
				System.out.print(value + " ");
			System.out.println();
		}
	}

	private static void processLine(String line) {
		//System.out.println("hello");
		CSVMachine m = new CSVMachine();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			//System.out.println(c);
			//System.out.println(m.getCurrentState());
			m.processChar(c);
		}
		List<String> row = m.getRow();
		allrows.add(row);
	}
}