//Daniel Lee
//Assignment 8

package hw.hw8;

import java.util.*;

public class CSVMachine {

	List<String> row;
	private State BeginField;
	private State Error;
	private State QuotedField;
	private State SeenAQuote;
	private State UnquotedField;
	
	private State currentState;
	private String currentString;
	private int index = 0;
	
	public CSVMachine() {
		row = new ArrayList<String>();
		row.add(currentString);
		BeginField = new BeginField(this);
		Error = new Error(this);
		QuotedField = new QuotedField(this);
		SeenAQuote = new SeenAQuote(this);
		UnquotedField = new UnquotedField(this);
		currentState = BeginField;
		currentString = "";
	}
	
	public List<String> getRow() {
		return row;
	}
	
	public void processChar(char c) {
		Character character = c;
		if (character.equals(',')){
			//System.out.println("yes");
			currentState.seeComma();
		}
		else if (character.equals('"')){
			currentState.seeQuote();
		}
		else {
			currentState.seeOther(c);
		}
	}
	
	public void setState(State state) {
		currentState = state;
	}
	
	public State getBeginFieldState() {
		return BeginField;
	}
	
	public State getErrorState() {
		return Error;
	}
	
	public State getQuotedFieldState() {
		return QuotedField;
	}
	
	public State getSeenAQuoteState() {
		return SeenAQuote;
	}
	
	public State getUnquotedFieldState() {
		return UnquotedField;
	}
	
	public State getCurrentState() {
		return currentState;
	}
	
	public void resetString() {
		currentString = "";
		index++;
		//System.out.println(index);
		row.add("");
	}
	
	public void addToString(String c) {
		currentString += c;
		row.set(index,currentString);
	}
	
	public void addError() {
		row.set(index,"ERROR!");
	}
}
