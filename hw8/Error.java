//Daniel Lee
//Assignment 8

package hw.hw8;

public class Error implements State {
	private CSVMachine m;
	
	public Error(CSVMachine m) {
		this.m = m;
	}
	
	public void seeQuote() {
		m.setState(m.getErrorState());
	}

	public void seeComma() {
		m.addError();
		m.resetString();
		m.setState(m.getBeginFieldState());
	}

	public void seeOther(char c) {
		m.setState(m.getErrorState());
	}
}
