package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {

	SudokuVerifier sudoku;

	@Before
	public void setUp() throws Exception {
		sudoku = new SudokuVerifier();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalSizeSolution.class)
	public void addSolutionIllegalSizeSolutionException() throws IllegalSizeSolution {
		// Arrange
		// Act
		sudoku.verify("23648957694");
	}

	@Test
	public void validSolutionString() throws IllegalSizeSolution {
		// Arrange
		int result;
		// Act
		result = sudoku.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		// Assert
		assertEquals(0, result);
	}


	@Test
	public void invalidCharacterOfString() throws IllegalSizeSolution {
		// Arrange
		int result;
		// Act
		result = sudoku.verify("407369825632158947958724316825437169791586432346912758289643571573291684164875293");
		// Assert
		assertEquals(-1, result);
	}

	@Test
	public void invalidSubGridOfString() throws IllegalSizeSolution {
		// Arrange
		int result;
		// Act
		result = sudoku.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875299");
		// Assert
		assertEquals(-2, result);
	}

	@Test
	public void invalidRowOfString() throws IllegalSizeSolution {
		// Arrange
		boolean result;
		// Act
		result = sudoku.validSubRow("417369825632158947958724316825437169791586432346912758289643571573291684164875299");
		// Assert
		assertFalse(result);
	}

	@Test
	public void invalidColumnOfString() throws IllegalSizeSolution {
		// Arrange
		boolean result;
		// Act
		result = sudoku.validSubColumn("417369825632158947958724316825437169791586432346912758289643571573291684164875299");
		// Assert
		assertFalse(result);
	}
	
	
}
