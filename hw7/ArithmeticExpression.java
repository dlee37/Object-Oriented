//Daniel Lee
//Assignment 7

package hw.hw7;

import java.util.*;

public interface ArithmeticExpression extends Iterable<ArithmeticExpression> {
	
	public String toString();

	public void addChild(ArithmeticExpression n);

	public int eval(Map<String, Integer> m);

	public boolean isNumber();

	public default boolean checkVariable(ArithmeticExpression v) {
		if (v instanceof Variable)
			return true;
		else
			return false;
	}

	public default void traverse() {

		if (checkVariable(this)) {
			String k = "Variable: " + this + " ";
			System.out.println(k);
		}

		else {
			Iterator<ArithmeticExpression> i = this.iterator();
			if (i == null)
				return;
			while (i.hasNext()) {
				ArithmeticExpression a = (ArithmeticExpression) i.next();
				a.traverse();
			}
		}
	}
}