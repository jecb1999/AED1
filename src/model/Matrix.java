
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
	
	
	
	public Number[][] getNumbers() {
		return numbers;
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
		boolean isPrime = true;
		if (n <= 1) {
			isPrime = false;
		}
		boolean found = false;
		for (int i = 2; i < n && found == false; i++) {
			if (n % i == 0) {
				isPrime = false;
				found = true;
			}
		}
		System.out.println(isPrime);
		return isPrime;
	}
	
	//method 2
	
	public void eristotenes() {
		int stop = numbers.length * numbers[0].length;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 1; j < numbers[0].length; j++) {				
				if(numbers[i][j].isPrime()) {
					int conta = 2;
					int m = 0;
					for (int j2 = 0; j2< numbers.length && m <stop ; j2++) {
						for (int k = 0;k<numbers[0].length && m<stop; k++) {
							m = (numbers[i][j].getValue()*conta);
								if(numbers[j2][k].getValue() == m ) {
									numbers[j2][k].setPrime(false);
									conta++;
								}
						}
					}
				}
			}
			
		}
	}
	
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
					number2++;
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
	
	public void print() {
		String a = "";
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[0].length; j++) {
				if(numbers[i][j].isPrime()) {					
					a+= numbers[i][j].getValue()+" ";
				}
				if(j == numbers[0].length-1) {
					a += "\n";
				}
				
			}
			
		}
		System.out.println(a);
	}
			
}

