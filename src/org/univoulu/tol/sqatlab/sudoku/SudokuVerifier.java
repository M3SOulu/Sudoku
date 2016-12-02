package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	private String candidateSolution;
	private int verify = 0;
	private final int FIRST_RULE_VIOLATION = -1;
	private final int SECOND_RULE_VIOLATION = -2;
	private final int THIRTH_RULE_VIOLATION = -3;
	private final int FOURTH_RULE_VIOLATION = -4;
	private final int STRING_LENGHT = 81;
	/**
	 * Costruttore della classe SudukuVerifier.
	 * @param candidateSolution stringa contenenete 81 caratteri rappresentante una possibile soluzione del sudoku. 
	 * @throws IllegalSudokuSolutionException eccezzione lanciata nel caso in cui la stringa passata non sia di 81 caratteri
	 */
	public SudokuVerifier(String candidateSolution) throws IllegalSudokuSolutionException {
		if(candidateSolution.length() == STRING_LENGHT)
			this.candidateSolution = candidateSolution;	
		else
			throw new IllegalSudokuSolutionException();
		
		
	}

	/**
	 * Funzione per la verifica della possibile soluzione del sudoku.
	 * @return -1 se la stringa non contiene solo numeri da 1 a 9, -2 se in una o più sottogriglie 9x9 sono presentu numeri ripetuti,
	 * -3 se in una o più righe sono presenti numeri ripetuti, -4 se in una o più colonne sono presenti numeri ripetuti.  
	 */
	public int verify() {

		firstRule();

		if (verify != FIRST_RULE_VIOLATION) {
			secondRule();

			if (verify != SECOND_RULE_VIOLATION)
				thirdhRule();

			if (verify != THIRTH_RULE_VIOLATION) 
				fourthRule();

			

		}

		return verify;
	}
/*
 * Controlla che nella stringa passatagli, s, non ci siano caratteri ripetuti.
 * ritorna true se non ci sono caratteri ripetuti, false altrimenti.
 */
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
/*
 * Estrae la sottogriglia dalla stringa candidateSolution , indicandogli da quale carattere partire,
 * estrae 3 caratteri ogni 6 caratteri e li concatena in una stringa.
 */
	private String subGrid(int start) {

		return candidateSolution.substring(start, start + 3)
				.concat(candidateSolution.substring(start + 9, start + 9 + 3))
				.concat(candidateSolution.substring(start + 9 + 9, start + 9 + 9 + 3));
	}
/*
 * Estre tutte le sottogrigle dalla stringa candidateSolution
 * e controlla che non ci siano numeri ripetuti nel qual caso imposto la varibile verify uguale a -2.
 */
	private void secondRule() {
		int firstThreeChars = 6;
		int factorToExtractFirstThreeChars = 3;
		int factorToExtractSubgridForColumns = 27;
		int factorToExtractThreeSubgridsToTime = 27 * 2;

		//salta di 3 caratteri in 3 caratteri per 3 volte. (cicla sulla prima riga)
		
		for (int i = 0; i <= firstThreeChars; i += factorToExtractFirstThreeChars ) {
			
			//salta di 27 caratteri in 27 per 3 volte. (per ogni valore di i estrae le sottogrigle in verticale )
			
			for (int j = i; j <= i + (factorToExtractThreeSubgridsToTime); j += factorToExtractSubgridForColumns) {
				
				if (!check(subGrid(j)))
					verify = SECOND_RULE_VIOLATION;

			}
		}

	}
/*
 * Controlla che nelle righe non ci siano numeri ripetuti nel qual caso imposta la variabile verify uguale a -3
 */
	private void thirdhRule() {
	int positionOfTheFirstCharOfTheLastRows = 73;
	int factorToExtractOneRowsToTime = 9;
	
	//Cicla per 9 volte saltando di 9 caratteri in 9 caratteri per estraendo 9 caratteri per volta dalla stringa candidateSolution.
		for (int i = 0; i < positionOfTheFirstCharOfTheLastRows; i += factorToExtractOneRowsToTime) {
			if (!check(rows(i)))
				verify = THIRTH_RULE_VIOLATION;

		}

	}
	
	/*
	 * Estre le righe dalla stringa candidateSolution. 
	 * Data una posizione di inizio ritorna una stringa contente i suceessivi 8 caratteri compreso quello inziale.
	 */
	private String rows(int start) {
		return candidateSolution.substring(start, start + 9);

	}

	/*
	 * Estrae le righe dalla stringa candidateSolution e controlla che non ci siano caratteri ripetuti,
	 * nel qual caso imposta il valore veridy uguale a -4.
	 */
	private void fourthRule() {
		char[] cA = new char[9];
		//cicla nove volte (sulle prime 9 posizoni della prima riga)
		for (int j = 0; j < 9; j++) {
			int k = 0;
			//cicla nove volte. per ogni posizione di j estrae 1 carattere ogni 9, fino a 9 caratteri.  
			for (int i = j; i <= j + (9 * 8); i += 9) {
				//Memorizza ogni carattere in un array.
				cA[k] = candidateSolution.charAt(i);
				k++;
			}
			//Per ogni 9 caratteri estratti (colonna) controlla che non ci siano caratteri ripetuti.
			if (!check(new String(cA)))
				verify = FOURTH_RULE_VIOLATION;

		}

	}
/*
 * Controlla che ogni carattere della stringa candidateSolution sia un numero compreso tra 1 e 9. 
 */
	private void firstRule() {
		char[] d = candidateSolution.toCharArray();

		for (char c : d) {
			if (!Character.isDigit(c)) {
				verify = FIRST_RULE_VIOLATION;
			}
		}
		
		if(candidateSolution.contains("0"))
			verify = FIRST_RULE_VIOLATION;

	}

}
