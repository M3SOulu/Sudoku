package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {
	 
	

	@Test
	public void test() {
		SudokuVerifier sv = new SudokuVerifier("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(0, sv.verify());
	}
	
	@Test
	public void test1() {
	SudokuVerifier sv = new SudokuVerifier("4173682563c158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(-1, sv.verify());
	}
	
	@Test
	public void test2() {
		SudokuVerifier sv = new SudokuVerifier("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
		assertEquals(-2, sv.verify());
	}

}
