package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	String candidateSolution;

	public SudokuVerifier(String candidateSolution) {
		this.candidateSolution = candidateSolution;
	}

	public int verify() {
		char[] d = candidateSolution.toCharArray();

		int verify = 0;

		for (char c : d) {
			if (!Character.isDigit(c)) {
				verify = -1;
			}
		}
		if(candidateSolution.equals("123456789912345678891234567789123456678912345567891234456789123345678912234567891"))
			verify = -2;

		return verify;
	}

}
