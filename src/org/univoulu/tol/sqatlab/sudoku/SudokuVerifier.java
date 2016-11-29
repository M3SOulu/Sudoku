package org.univoulu.tol.sqatlab.sudoku;

import exceptions.NotValidSolutionLength;

public class SudokuVerifier {

	public char[][] grid;

	public SudokuVerifier() {
		grid = new char[9][9];
	}

	public int verify(String candidateSolution) throws NotValidSolutionLength {

		if (candidateSolution.length() != 81)
			throw new NotValidSolutionLength();

		// Return -1: means it is violating Rule #1
		for (int i = 0; i < candidateSolution.length(); i++)
			if (!isAValidDigit(candidateSolution.charAt(i)))
				return -1;
		
		convertIntoGrid(candidateSolution);
		
		// Return -2: means it is violating Rule #2
		if(containsDuplicateInSubgrid())
			return -2;


		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char charToControl = grid[i][j];

				// Return -3: means it is violating Rule #3
				for (int nextCharInTheRow = j + 1; nextCharInTheRow < 9; nextCharInTheRow++)
					if (charToControl == grid[i][nextCharInTheRow])
						return -3;
				// Return -4: means it is violating Rule #4
				for (int nextCharInTheColumn = i + 1; nextCharInTheColumn < 9; nextCharInTheColumn++)
					if (charToControl == grid[nextCharInTheColumn][j])
						return -4;
			}
		}



		// Return 0: means it is a valid Sudoku solution
		return 0;
	}

	private boolean containsDuplicateInSubgrid() {
		
		for (int subgridNumber = 0; subgridNumber < 4; subgridNumber++) {
			String subgrid = "";
			for (int i = 0; i < 3; i++){
				for (int j = 0; j < 3; j++) {
					subgrid += grid[i][j];
				}
			}
			
			for(int i = 0; i < 9; i++){
				String numberToControl = subgrid.substring(i, i+1);
				String nextNumbersInTheSubgrid = subgrid.substring(i+1);
				if(nextNumbersInTheSubgrid.contains(numberToControl))
					return true;
			}
		}
		
		return false;
	}

	private void convertIntoGrid(String candidateSolution) {
		for (int row = 0, i = 0; row < 9 && i < candidateSolution.length(); row++, i += 9) {
			String newRow = candidateSolution.substring(i, i + 9);
			grid[row] = newRow.toCharArray();
		}
	}

	private boolean isAValidDigit(Character nextChar) {
		return Character.isDigit(nextChar) && nextChar != '0';
	}
}
