package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSudokuVerifierRule2 {
	SudokuVerifier sd;

	@Before
	public void setUp(){
		sd = new SudokuVerifier( 9 );
	}
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInFirstSubGrid()
	{
		assertEquals( -2, sd.verify( "417369825"
								   + "632158947"
								   + "988724316"	//8 appears twice
								   + "825437169"
								   + "791586432"
								   + "346912758"
								   + "289643571"
								   + "573291684"
								   + "164875293" ) );
	}
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInSecondSubGrid()
	{
		assertEquals( -2, sd.verify( "417369825"
								   + "632118947"	//1 appears twice
								   + "958724316"	
								   + "825437169"
								   + "791586432"
								   + "346912758"
								   + "289643571"
								   + "573291684"
								   + "164875293" ) );
	}
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInThirdSubGrid()
	{
		assertEquals( -2, sd.verify( "417369822"	//2 appears twice
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
	public void testFormatSudokuStringNumberxAppearsTwiceInFourthSubGrid()
	{
		assertEquals( -2, sd.verify( "417369825"	
								   + "632158947"	
								   + "958724316"	
								   + "825437169"
								   + "791586432"
								   + "336912758"	//3 appears twice
								   + "289643571"
								   + "573291684"
								   + "164875293" ) );
	}
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInFifthSubGrid()
	{
		assertEquals( -2, sd.verify( "417369825"	
								   + "632158947"	
								   + "958724316"	
								   + "825437169"
								   + "791556432"	//5 appears twice
								   + "346912758"	
								   + "289643571"
								   + "573291684"
								   + "164875293" ) );
	}
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInSixthSubGrid()
	{
		assertEquals( -2, sd.verify( "417369825"	
								   + "632158947"	
								   + "958724316"	
								   + "825437199"	//9 appears twice
								   + "791586432"
								   + "346912758"	
								   + "289643571"
								   + "573291684"
								   + "164875293" ) );
	}
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInSeventhSubGrid()
	{
		assertEquals( -2, sd.verify( "417369825"	
								   + "632158947"	
								   + "958724316"	
								   + "825437169"	
								   + "791586432"
								   + "346912758"	
								   + "289643571"
								   + "573291684"
								   + "114875293" ) );	//1 appears twice
	}
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInEighthSubGrid()
	{
		assertEquals( -2, sd.verify( "417369825"	
								   + "632158947"	
								   + "958724316"	
								   + "825437169"	
								   + "791586432"
								   + "346912758"	
								   + "289643571"
								   + "573299684"		//9 appears twice
								   + "164875293" ) );
	}
	
	@Test
	public void testFormatSudokuStringNumberxAppearsTwiceInNithSubGrid()
	{
		assertEquals( -2, sd.verify( "417369825"	
								   + "632158947"	
								   + "958724316"	
								   + "825437169"	
								   + "791586432"
								   + "346912758"	
								   + "289643577"		//7 appears twice
								   + "573291684"
								   + "164875293" ) );
	}
	
	
}
