package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	private static final int lenghtSolution = 81;

	public int verify(String candidateSolution) throws IllegalSizeSolution {
		char[] solutionArray = candidateSolution.toCharArray();
		int sizeSolution = solutionArray.length;
		if (sizeSolution != lenghtSolution)
			throw new IllegalSizeSolution();

		if (!validCharInput(solutionArray))
			return -1;
		if (!validSubGrid(solutionArray))
			return -2;
		if (!validSubRow(candidateSolution))
			return -3;
		if (!validSubColumn(candidateSolution))
			return -4;

		return 0;
	}

	private boolean validCharInput(char[] solutionArray) {
		for (char c : solutionArray) {
			if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
					&& c != '9')
				return false;
		}
		return true;
	}

	private boolean validSubGrid(char[] solutionArray) {
		String subGrid;
		int i = 0;
		while (i < 61) {
			subGrid = "" + solutionArray[i] + solutionArray[i + 1] + solutionArray[i + 2] + solutionArray[i + 9]
					+ solutionArray[i + 10] + solutionArray[i + 11] + solutionArray[i + 18] + solutionArray[i + 19]
					+ solutionArray[i + 20];
			if (!diversityOfCharOfString(subGrid))
				return false;
			if (i == 6)
				i = 27;
			else if (i == 33)
				i = 54;
			else
				i += 3;
		}
		return true;
	}

	public boolean validSubRow(String candidateSolution) {
		String temp;
		for (int i = 0; i < lenghtSolution; i += 9) {
			temp = candidateSolution.substring(i, i + 9);
			if (!diversityOfCharOfString(temp))
				return false;
		}
		return true;
	}

	public boolean validSubColumn(String candidateSolution) {
		char[] solutionArray=candidateSolution.toCharArray();
		String temp;
		for (int i = 0; i < 9; i++) {
			temp ="" + solutionArray[i] + solutionArray[i+9] + solutionArray[i+18] + solutionArray[i+27]
							+ solutionArray[i+36] + solutionArray[i+45] + solutionArray[i+54] + solutionArray[i+63]
							+ solutionArray[i+72];
			if (!diversityOfCharOfString(temp))
				return false;
		}
		return true;
	}

	private boolean diversityOfCharOfString(String subGrid) {
		char[] subGridArray = subGrid.toCharArray();
		for (int y = 0; y < 8; y++) {
			for (int z = y + 1; z < 9; z++) {
				if (subGridArray[y] == subGridArray[z])
					return false;
			}
		}
		return true;
	}

}
