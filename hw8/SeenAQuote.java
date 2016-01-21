//Daniel Lee
//Assignment 8

package hw.hw8;

public class SeenAQuote implements State {
	private CSVMachine m;
	
	public SeenAQuote(CSVMachine m) {
		this.m = m;
	}

	public void seeQuote() {
		Character c = '"';
		String character = c.toString();
		m.addToString(character);
		m.setState(m.getQuotedFieldState());
	}

	public void seeComma() {
		m.resetString();
		m.setState(m.getBeginFieldState());
	}

	public void seeOther(char c) {
		m.setState(m.getErrorState());
	}
}
