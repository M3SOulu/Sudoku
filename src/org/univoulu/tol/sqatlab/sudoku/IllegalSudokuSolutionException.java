package org.univoulu.tol.sqatlab.sudoku;

public class IllegalSudokuSolutionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalSudokuSolutionException() {
		super("La stringa contiene più di 81 caratteri o meno di 81 caratteri");
	}

}
