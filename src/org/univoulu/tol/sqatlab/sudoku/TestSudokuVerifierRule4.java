package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifierRule4 {
	SudokuVerifier sd;

	@Before
	public void setUp(){
		sd = new SudokuVerifier( 9 );
	}

	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInFirstColumn() {
		assertEquals( -4, sd.verify( "123456879"
				+ "456789123"
				+ "789123456"
				+ "123456789"
				+ "456789123"
				+ "789123456"
				+ "123456789"
				+ "456789123"
				+ "789123456" ) );
	}

	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInSecondColumn() {
		assertEquals( -4, sd.verify( "147369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293" ) );
	}

	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInEighthColumn() {
		assertEquals( -4, sd.verify( "417369825"
								   + "632158947"
								   + "958724316"
								   + "825437169"
								   + "791586432"
								   + "346912758"
								   + "289643571"
								   + "573291684"
								   + "164875239" ) );
	}
	
	


}
