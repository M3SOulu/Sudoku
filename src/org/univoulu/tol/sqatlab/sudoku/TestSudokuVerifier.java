package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.NotValidSolutionLength;

public class TestSudokuVerifier {

	@Test(expected = NotValidSolutionLength.class)
	public void stringShorterThan81ShouldRiseAnException() throws NotValidSolutionLength{
		//Arrange
		String solution = "123456789";
		//Act
		SudokuVerifier.verify(solution);
	}

	@Test(expected = NotValidSolutionLength.class)
	public void stringLongerThan81ShouldRiseAnException() throws NotValidSolutionLength{
		//Arrange
		String solution = "123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		//Act
		SudokuVerifier.verify(solution);
	}

	@Test
	public void stringContainingNonDigitCharacterShouldReturnMinus1() throws NotValidSolutionLength{
		//Arrange
		String solution = "12345678912345678912345678912356789123456789123456789123456789123456789123456789a";
		//Act & Assert
		assertTrue(SudokuVerifier.verify(solution) == -1);
	}
	
	@Test
	public void stringContainZeroShouldReturnMinus1() throws NotValidSolutionLength{
		//Arrange
		String solution = "123456789123456789123456789123567891234567891234567891234567891234567891234567890";
		//Act & Assert
		assertTrue(SudokuVerifier.verify(solution) == -1);
	}
}
