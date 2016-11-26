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
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInSecondRow() {
		assertEquals( -3, sd.verify( "123456789"
								   + "459789123"
								   + "786123456"
								   + "123456789"
								   + "456789123"
								   + "789123456"
								   + "123456789"
								   + "456789123"
								   + "789123456" ) );
	}
	
	

}
