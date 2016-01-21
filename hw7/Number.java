package hw.hw7;

import java.util.Iterator;
import java.util.*;

public class Number implements ArithmeticExpression {
	
	public int number;

	public Number(int number) {
		this.number = number;
	}

	public String toString() {
		return Integer.toString(number);
	}

	public void addChild(ArithmeticExpression n) {
		throw new UnsupportedOperationException();
	}

	public Iterator<ArithmeticExpression> iterator() {
		return null;
	}
	
	public int eval(Map<String,Integer> m) {
		
		return number;
	}
	
	public boolean isNumber() {
		return true;
	}
}
