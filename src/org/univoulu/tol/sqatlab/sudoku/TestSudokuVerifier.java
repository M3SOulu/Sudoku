package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {
	
	SudokuVerifier sudoVer;
	
	
	@Before
	public void setUp(){
		
		 sudoVer= new SudokuVerifier();
	}
	
	//check first rule
	@Test
	public void TestSolutionLength() {		
		
		//size:
		//0
		assertEquals(-1,sudoVer.verify(""));
		
		//80
		assertEquals(-1,sudoVer.verify("41736982563215894795872431682543716979158643234691275828964357157329168416487529"));
		
		//82
		assertEquals(-1,sudoVer.verify("4173698256321589479587243168254371697915864323469127582896435715732916841648752930"));
		
		//81
		assertEquals(0,sudoVer.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
		
		
	}
	
	@Test
	public void testNotDigitChars(){
		
		String candidateSolution="41736982563215894795872431682543716979158-432346912758289643571573291684164875293";
		
		assertEquals(-1,sudoVer.verify(candidateSolution));
	}
	
	@Test
	public void testGetSubString(){
		
		String s="123123123456456456789789789123123123456456456789789789123123123456456456789789789";
		
		assertEquals("123456789", sudoVer.getSubGrid(s).get(0));
		assertEquals("123456789", sudoVer.getSubGrid(s).get(1));
		assertEquals("123456789", sudoVer.getSubGrid(s).get(2));
		assertEquals("123456789", sudoVer.getSubGrid(s).get(4));
		assertEquals("123456789", sudoVer.getSubGrid(s).get(5));
		assertEquals("123456789", sudoVer.getSubGrid(s).get(6));
		assertEquals("123456789", sudoVer.getSubGrid(s).get(7));
		assertEquals("123456789", sudoVer.getSubGrid(s).get(8));
		
	}
	
	
	@Test
	public void testSecondRule(){
		
		String s="123123123456456456789789789123123123456456456789789789123123123456456456789789789";
		
		assertEquals(0,sudoVer.verify(s));
		
		s="417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		assertEquals(0,sudoVer.verify(s));
		
		s="117369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		assertEquals(-2,sudoVer.verify(s));
	}
	

}
