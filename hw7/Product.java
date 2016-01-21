//Daniel Lee
//Assignment 7

package hw.hw7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Product implements ArithmeticExpression {
	
	private List<ArithmeticExpression> product = 
			new ArrayList<ArithmeticExpression>();
	
	public String toString() {
		
		Iterator<ArithmeticExpression> i = iterator();
		int count = 0;
		//System.out.println(i.hasNext());
		if (i.hasNext() == false)
			return "1";
		
		String x = "(";
		while (i.hasNext()) {
			ArithmeticExpression n = (ArithmeticExpression) i.next();
			count++;
			if (count == product.size()) x += n.toString();
			else
				x += n.toString() + "*";
		}
		x += ")";
		return x;
	}
	
	public void addChild(ArithmeticExpression n) {
		product.add(n);
	}
	
	public Iterator<ArithmeticExpression> iterator() {
		//System.out.println(product);
		return product.iterator();
	}
	
	public int eval(Map<String,Integer> m) {
		int ans = 1;
		Iterator<ArithmeticExpression> i = iterator();
		if (i.hasNext() == false) return 0;
		
		while (i.hasNext()) {
			ArithmeticExpression n = (ArithmeticExpression) i.next();
			
			if (checkVariable(n)) ans *= m.get(n.toString());
			
			else
				ans *= n.eval(m);
		}
		
		return ans;
	}
	
	public boolean isNumber() {
		
		return false;
	}
}