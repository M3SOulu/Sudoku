package org.univoulu.tol.sqatlab.sudoku;

import exceptions.NotValidSolutionLength;

public class SudokuVerifier {
	

	public static int verify(String candidateSolution) throws NotValidSolutionLength{
		
		if(candidateSolution.length()!=81)
			throw new NotValidSolutionLength();
		
		int response = 0;
		
		// Return 0: means it is a valid Sudoku solution
		
		// Return -1: means it is violating Rule #1
		for(int i = 0; i<candidateSolution.length(); i++){
			Character nextChar = candidateSolution.charAt(i);
			if(isAValidDigit(nextChar))
				response = -1;
		}
		// Return -2: means it is violating Rule #2
		// Return -3: means it is violating Rule #3
		// Return -4: means it is violating Rule #4
		return response;
	}

	private static boolean isAValidDigit(Character nextChar) {
		return !Character.isDigit(nextChar) || nextChar == '0';
	}
}
