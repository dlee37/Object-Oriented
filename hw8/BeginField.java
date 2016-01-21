//Daniel Lee
//Assignment 8

package hw.hw8;

public class BeginField implements State {
	private CSVMachine m;
	
	public BeginField(CSVMachine m) {
		this.m = m;
	}
	
	public void seeQuote() {
		m.setState(m.getQuotedFieldState());
	}
	
	public void seeComma() {
		m.addToString(",");
		m.setState(m.getUnquotedFieldState());
	}
	
	public void seeOther(char c) {
		Character temp = c;
		String character = temp.toString();
		m.addToString(character);
		m.setState(m.getUnquotedFieldState());
	}
}
