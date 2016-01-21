//Daniel Lee
//Assignment 7

package hw.hw7;

import java.util.*;
import java.util.Iterator;
import java.util.Map;

public class Plus implements ArithmeticExpression {
	
	private List<ArithmeticExpression> add = 
			new ArrayList<ArithmeticExpression>();
	
	public String toString() {
		Iterator<ArithmeticExpression> i = iterator();
		int count = 0;
		if (i.hasNext() == false) return "0";
		String ex = "(";
		
		while (i.hasNext()) {
			ArithmeticExpression n = (ArithmeticExpression) i.next();
			count += 1;
			if (count == add.size()) ex += n.toString();
			else
				ex += n.toString() + "+";
		}
		
		ex += ")";
		return ex;
	}

	public void addChild(ArithmeticExpression e) {
		add.add(e);
		//System.out.println(add);
	}
	
	public Iterator<ArithmeticExpression> iterator() {
		return add.iterator();
	}
	
	public int eval(Map<String,Integer> m) {
		int ans = 0;
		Iterator<ArithmeticExpression> i = iterator();
		if (i.hasNext() == false) return 0;
		
		while (i.hasNext()) {
			ArithmeticExpression n = (ArithmeticExpression) i.next();
			if (checkVariable(n)) ans += m.get(n.toString());
			else ans += n.eval(m);
		}
		
		return ans;
	}
	
	public boolean isNumber() {

		//Iterator<ArithmeticExpression> i = iterator();
		/* while (i.hasNext()) {
			ArithmeticExpression n = (ArithmeticExpression) i.next();
			//System.out.println(n);
			return false;
		} */
		return false;
	}
}