//Daniel Lee
//Assignment 7

package hw.hw7;

import java.util.*;

public class HW7Test {

	public int maxValue = -999999999;
	public int nums = 0;
	
	public static void main(String[] args) {

		HW7Test test = new HW7Test();
		ArithmeticExpression x = new Plus();
		Map<String, Integer> varMap = new HashMap<String, Integer>();
		//System.out.println(x);
		x.addChild(new Number(3));
		x.addChild(new Number(2));
		x.addChild(new Number(5));
		// System.out.println(x);
		ArithmeticExpression y = new Product();
		y.addChild(new Number(5));
		y.addChild(new Number(10));
		y.addChild(x);
		// y.addChild(x);
		//System.out.println(y.eval(varMap));
		//System.out.println(y);
		ArithmeticExpression z = new Variable("x");
		ArithmeticExpression a = new Variable("w");
		varMap.put("x", 2);
		varMap.put("w", 1);
		x.addChild(z);
		//System.out.println(y.eval(varMap));
		//System.out.println(y);
		y.addChild(a);
		y.addChild(z);
		System.out.println(y);
		System.out.println(y.eval(varMap));
		test.countMaxAndNumbers(y,varMap);
		System.out.println("Max value is: " + test.getMax());
		System.out.println("Number of integers is: " + test.getNums());
		y.traverse();
	}

	public void countMaxAndNumbers(ArithmeticExpression a, 
			Map<String,Integer> m) {
		
		if (a.isNumber()) {
			//System.out.println("Hello");
			nums++;
			maxValue = Math.max(maxValue, a.eval(m));
		} 
		
		else {
			Iterator<ArithmeticExpression> i = a.iterator();
			if (i == null) return;
			while (i.hasNext()) {
				ArithmeticExpression next = i.next();
				countMaxAndNumbers(next,m);
			} 
		}
	}
	
	private int getMax() {
		return maxValue;
	}
	
	private int getNums() {
		return nums;
	}
}