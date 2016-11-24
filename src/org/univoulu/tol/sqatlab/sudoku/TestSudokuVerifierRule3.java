package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifierRule3 {
	SudokuVerifier sd;

	@Before
	public void setUp(){
		sd = new SudokuVerifier( 9 );
	}
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInFirstRow() {
		assertEquals( -3, sd.verify( "123123123"
				  				   + "456456456"
				  				   + "789789789"
				  				   + "123123123"
				  				   + "456456456"
				  				   + "789789789"
				  				   + "123123123"
				  				   + "456456456"
				  				   + "789789789" ) );
	}

}
