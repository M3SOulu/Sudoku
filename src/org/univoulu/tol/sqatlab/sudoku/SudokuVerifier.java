package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	String candidateSolution;
	int verify = 0;

	public SudokuVerifier(String candidateSolution) {
		this.candidateSolution = candidateSolution;
	}

	public int verify() {
		char[] d = candidateSolution.toCharArray();

		for (char c : d) {
			if (!Character.isDigit(c)) {
				verify = -1;
			}
		}

		if (verify == 0) {

			secondRule();
			
			

		}

		return verify;
	}

	private void check(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					verify = -2;
			}
		}

	}

	private String subGrid(int start) {

		return candidateSolution.substring(start, start + 3)
				.concat(candidateSolution.substring(start + 9, start + 9 + 3))
				.concat(candidateSolution.substring(start + 9 + 9, start + 9 + 9 + 3));
	}

	private void secondRule() {
		for (int i = 0; i < 7; i += 3) {
			for (int j = i; j <= i + (27 * 2); j += 27) {
				check(subGrid(j));
			}
		}

	}

}
