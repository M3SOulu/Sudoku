package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.NotValidSolutionLength;

public class TestSudokuVerifier {

	SudokuVerifier verifier;

	@Before
	public void setUp() throws Exception {
		// Arrange
		verifier = new SudokuVerifier();
	}

	@Test(expected = NotValidSolutionLength.class)
	public void stringShorterThan81ShouldRiseAnException() throws NotValidSolutionLength {
		// Arrange
		String solution = "123456789";
		// Act
		verifier.verify(solution);
	}

	@Test(expected = NotValidSolutionLength.class)
	public void stringLongerThan81ShouldRiseAnException() throws NotValidSolutionLength {
		// Arrange
		String solution = "4173698256321589479587243168254371697915864323469127582896435715732916841648752938";
		// Act
		verifier.verify(solution);
	}

	@Test
	public void stringContainingNonDigitCharacterShouldReturnMinus1() throws NotValidSolutionLength {
		// Arrange
		String solution = "41736982563215894795872431682543716979158643234691275828964357157329168416487529a";
		// Act & Assert
		assertTrue(verifier.verify(solution) == -1);
	}

	@Test
	public void stringContainZeroShouldReturnMinus1() throws NotValidSolutionLength {
		// Arrange
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875290";
		// Act & Assert
		assertTrue(verifier.verify(solution) == -1);
	}

	@Test
	public void repetitionInARowShouldReturnMinus3() throws NotValidSolutionLength {
		//Arrange
		String solution = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
		//Act & Assert
		assertTrue(verifier.verify(solution) == -3);
	}
	
	@Test
	public void repetitionInAColumnShouldReturnMinus4() throws NotValidSolutionLength {
		//Arrange
		String solution = "417369825632158947958724316825437169791586432346912758289643571574291683164875293";
		//Act & Assert
		assertTrue(verifier.verify(solution) == -4);
	}
}
