package model;

public class Matrix {

	private int number;
	private int option;
	private Number[][] numbers;

	public Matrix(int n, int o) {
		this.number = n;
		this.option = o;
		numbers = new Number[row()][column()];
		fillMatrix();
	}
	
	//generate row matrix
	public int row() {
		return (int) Math.sqrt(number);
	}
	
	//generate column matrix
	public int column() {
		int reference = (int) Math.sqrt(number);
		if (reference * row() == number) {
			return (int) Math.sqrt(number);
		} else {
			return (int) Math.sqrt(number) + 1;
		}
	}
	
	//method 1
	public boolean primeNumber1(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	//method 2
	
	//TODO
	
	//method 3
	
	//TODO

//	generate values matrix
	public void fillMatrix() {
		int number2 = 1;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if (number2 <= number) {
					numbers[i][j] = new Number();
					numbers[i][j].setValue(number2);
					number++;
				}
			}
		}
	}
	
	public void option(int option) {
		switch(option) {
		case 1:
			method1();
		case 2:
			
		case 3:
			
		}
	}

	public void method1() {
		for (int i = 0; i < numbers.length; i++) {
			for (int k = 0; k < numbers[0].length; k++) {
				int val = numbers[i][k].getValue();
				if (primeNumber1(val) == true) {
					numbers[i][k].setPrime(true);
				}
			}
		}
	}
			
}
