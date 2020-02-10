package model;

public class Number {

	private boolean isPrime;
	private int value;

	public Number() {
		this.isPrime = false;
		this.value = 0;
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
	
	

}
