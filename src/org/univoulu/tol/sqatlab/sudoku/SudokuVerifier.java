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

			if (verify != -2)
				thirdhRule();

			if (verify != -3) {
				fourthRule();

			}

		}

		return verify;
	}

	private boolean check(String s) {
		boolean check = true;

		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					check = false;
			}
		}
		return check;
	}

	private String subGrid(int start) {

		return candidateSolution.substring(start, start + 3)
				.concat(candidateSolution.substring(start + 9, start + 9 + 3))
				.concat(candidateSolution.substring(start + 9 + 9, start + 9 + 9 + 3));
	}

	private void secondRule() {

		for (int i = 0; i < 7; i += 3) {
			for (int j = i; j <= i + (27 * 2); j += 27) {
				if (!check(subGrid(j)))
					verify = -2;

			}
		}

	}

	private void thirdhRule() {
		for (int i = 0; i < 73; i += 9) {
			if (!check(rows(i)))
				verify = -3;

		}

	}

	private String rows(int start) {
		return candidateSolution.substring(start, start + 9);

	}

	private void fourthRule() {
		char[] cA = new char[9];
		for (int j = 0; j < 9; j++) {
			int k = 0;
			for (int i = j; i <= j + (9 * 8); i += 9) {

				cA[k] = candidateSolution.charAt(i);
				k++;
			}
			if (!check(new String(cA)))
				verify = -4;

		}

	}

}
