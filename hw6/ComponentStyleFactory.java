package hw.hw6;

import java.awt.Color;

public class ComponentStyleFactory {
	
	private ComponentStyleFactory() {}
	
	public static ComponentStyleFactory instance() {
		return new ComponentStyleFactory();
	}
	
	public ComponentStyler create(Color x, Color y) {
		return new ComponentStyler(x,y);
	}
	
	public ComponentStyler createMonochrome(Color x) {
		
		float[] hsb = Color.RGBtoHSB(x.getRed(), x.getGreen(), x.getBlue(), null);
		Color y = Color.getHSBColor(hsb[0], 0.3f * hsb[1], hsb[2]);
		
		return new ComponentStyler(x,y);
	}
}
