//Daniel Lee
//Assignment 8

package hw.hw8;

public class UnquotedField implements State {
private CSVMachine m;
	
	public UnquotedField(CSVMachine m) {
		this.m = m;
	}

	public void seeQuote() {
		m.setState(m.getErrorState());
		//System.out.println(m.getCurrentState());
	}

	public void seeComma() {
		m.resetString();
		m.setState(m.getBeginFieldState());
		//System.out.println(m.getCurrentState());
	}

	public void seeOther(char c) {
		Character temp = c;
		String character = temp.toString();
		m.addToString(character);
		//System.out.println("this");
		m.setState(m.getUnquotedFieldState());
	}
}
