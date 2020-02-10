package model;

public class Matrix {

	private int n;
	private Number[][] m;

	public Matrix(int n) {
		this.n = n;
		m = new Number[row()][column()];
	}

	public int row() {
		return (int) Math.sqrt(n);
	}

	public int column() {
		int reference = (int) Math.sqrt(n);
		if (reference + row() == n) {
			return (int) Math.sqrt(n);
		} else {
			return (int) Math.sqrt(n) + 1;
		}
	}
	
	public boolean primeNumber(int n) {
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

	public void fillMatrix() {
		int number = 1;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (number <= n) {
					m[i][j] = new Number();
					m[i][j].setValue(number);
					if (primeNumber(number) == true) {
						m[i][j].setPrime(true);
					}
				}
			}
		}
	}



}
