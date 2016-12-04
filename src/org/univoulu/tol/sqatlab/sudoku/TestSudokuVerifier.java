package org.univoulu.tol.sqatlab.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestSudokuVerifier {

	public SudokuVerifier sudoku1;
	public String correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	public String incorrectSudoku = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	
	@Before
	public void setUp(){
		sudoku1 = new SudokuVerifier();
	}
	
	@Test
	public void testCorrectSudoku(){
		Assert.assertEquals(0, sudoku1.verify(correctSudoku));
	}
	
	@Test
	public void testNotPositiveNumbers(){
		Assert.assertEquals(-1, sudoku1.verify("-hjsbs9-994561322315"));
	}
	
	@Test
	public void testSubGridErrate(){
		Assert.assertEquals(-2, sudoku1.verify(incorrectSudoku));
	}
	
}
