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
	void a (){
		Matrix a = new Matrix(10, 1);
		String actual = a.print();
		assertEquals("2 3 "+"\n"+"5 7 "+"\n", actual);
	}
	
	@Test
	void b() {
		Matrix a = new Matrix(10, 2);
		String actual = a.print();
		assertEquals("1 2 3 "+"\n"+"5 7 "+"\n"+"10 ", actual);
	}
	
	@Test
	void c() {
		Matrix a = new Matrix(10, 3);
		String actual = a.print();
		assertEquals("1 2 3 "+"\n"+"5 7 "+"\n", actual);
	}

}
