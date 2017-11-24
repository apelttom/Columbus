package controller.math;

import model.math.SplittedDouble;

/*
 * With gratitude taken from https://stackoverflow.com/questions/24753177/how-to-split-a-double-number-by-dot-into-two-decimal-numbers-in-java
 */
public class DoubleSplitter {
	
	/**
	 * Can split you double number by dot in two parts
	 * @param number you would like to split
	 * @return number before dot and number after dot all packed in one nice class
	 */
	public static SplittedDouble doubleNumberSplit(double number){
	    int whole = (int) number;
	    int fract = (int) ((number - whole) * 10000);
	    return new SplittedDouble(whole, fract);
	}

}
