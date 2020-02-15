package model;

public class Number {

	private boolean isPrime;
	private int value;
	private boolean draw;

	public Number() {
		this.isPrime = true;
		this.value = 0;
		this.draw = false;
	}

	public boolean isPrime() {
		return isPrime;
	}

	public void setPrime(boolean isPrime) {
		this.isPrime = isPrime;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean getDraw() {
		return draw;
	}
	
	public void setDraw(boolean newDraw) {
		this.draw = newDraw;
	}
	
	

}
