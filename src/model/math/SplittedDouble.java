package model.math;

public class SplittedDouble {
	
	private int preDecimalDotPart;
	private int postDecimalDotPart;
	
	public SplittedDouble(int preDecimalDotPart, int postDecimalDotPart){
		this.preDecimalDotPart = preDecimalDotPart;
		this.postDecimalDotPart = postDecimalDotPart;
	}

	public int getPreDecimalDotPart() {
		return preDecimalDotPart;
	}

	public int getPostDecimalDotPart() {
		return postDecimalDotPart;
	}

}
