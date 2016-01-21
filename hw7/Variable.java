//Daniel Lee
//Assignment 7

package hw.hw7;

import java.util.*;

public class Variable implements ArithmeticExpression {

	public String v;
	
	public Variable(String v) {
		this.v = v;
	}
	
	public int evaluate() {
		
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return v;
	}
	
	public void addChild(ArithmeticExpression n) {
		throw new UnsupportedOperationException();
	}
	
	public Iterator<ArithmeticExpression> iterator() {
		return null;
	}
	
	public int eval(Map<String, Integer> m) {
		
		return m.get(v);
	}
	
	public boolean isNumber() {
		return false;
	}
}
