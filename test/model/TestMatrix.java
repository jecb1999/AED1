package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMatrix {

	
	@Test
	void RowMatrizTest() {
		Matrix a = new Matrix(100, 1);
		int actual = a.getNumbers().length;
		assertEquals(10, actual);
	}
	
	@Test
	void ColumMatrizTest() {
		Matrix a = new Matrix(27, 1);
		int actual = a.getNumbers()[0].length;
		assertEquals(6, actual);
	}
	
	@Test
	void fillMatriz() {
		Matrix a = new Matrix(27, 1);
		int actual = (a.getNumbers().length)*(a.getNumbers()[0].length);
		assertEquals(30, actual);
	}
	
	@Test
	void b() {
		Matrix a = new Matrix(10, 2);
		a.eristotenes();
		a.print();
	}
	
	@Test
	void c() {
		Matrix a = new Matrix(10, 2);
		a.method3();
		a.print();
	}

}
