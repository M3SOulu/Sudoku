package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifierRule1 {

	SudokuVerifier sd;

	@Before
	public void setUp(){
		sd = new SudokuVerifier( 9 );
	}

	@Test
	public void testFormatSudokuStringNull()
	{
		assertEquals( -1, sd.verify( null ) );
	}

	@Test
	public void testFormatSudokuStringEmpty()
	{
		assertEquals( -1, sd.verify( "" ) );
	}

	@Test
	public void testFormatSudokuStringNot81CharLenght()
	{
		assertEquals( -1, sd.verify( "0" ) );
	}

	@Test
	public void testCorrectFormatSudokuString81CharLenght()
	{
		assertEquals( 0, sd.verify( "417369825"
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
	public void testFormatSudokuStringNotNumbers()
	{
		assertEquals( -1, sd.verify( "Hello World" ) );
	}


}
