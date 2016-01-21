//Daniel Lee
//Assignment 8

package hw.hw8;

public class QuotedField implements State {
	private CSVMachine m;

	public QuotedField(CSVMachine m) {
		this.m = m;
	}

	public void seeQuote() {
		m.setState(m.getSeenAQuoteState());
	}

	public void seeComma() {
		m.addToString(",");
		m.setState(m.getQuotedFieldState());
	}

	public void seeOther(char c) {
		Character temp = c;
		String character = temp.toString();
		m.addToString(character);
		m.setState(m.getQuotedFieldState());
	}
}
