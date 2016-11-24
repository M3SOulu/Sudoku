package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	private int rowLenght;
	
	public SudokuVerifier( int rowLenght ){
		this.rowLenght = rowLenght;
	}
	
	/**
	 * 
	 * @param candidateSolution
	 * @return
	 */
	public int verify(String candidateSolution) {
		
		if( ! rule1( candidateSolution ) ){
			return -1;
		}
		
		if( ! rule2( candidateSolution ) ){
			return -2;
		}
		
		String subString;
		for( int i = 0; i < rowLenght; i++ ){
			subString = candidateSolution.substring(0, 9);
			if( ! containsOnlyDifferentValues( subString ) ){
				return -3;
			}
		}
		
		
		return 0;
	}
	
	
	
	/**
	 * All digits appear only once in a sub-grid, i.e. they cannot repeat.
	 * @param string
	 * @return
	 */
	private boolean rule2( String string ){
		int j = 0;
		String subGrid;
		Double subGridLenght = Math.sqrt( rowLenght );
		int n = subGridLenght.intValue();
		
		for( int i = 0; i < rowLenght; i++ ){
			subGrid = string.substring( j, (j+n)) +
					string.substring((j+rowLenght), (j+rowLenght+n)) +
					string.substring((j+rowLenght*2), (j+rowLenght*2+n));
			
			if( ! containsOnlyDifferentValues( subGrid ) ){
				return false;
			}
			
			if( ((i+1)%n) == 0 ){
				j += rowLenght*2 + n;
			}
			else{
				j += n;
			}
		}
		
		return true;
	}
	
	/**
	 * check if a string contains only different values
	 * @param subGrid
	 * @return true if all values are different
	 */
	private boolean containsOnlyDifferentValues( String subGrid ){
		for( int i = 0; i < subGrid.length() - 1; i++ ){
			
			char temp = subGrid.charAt( i );
			
			for( int j = i + 1; j < subGrid.length(); j++ ){
				if( temp == subGrid.charAt( j ) ){
					return false;
				}
			}
			
		}
		
		return true;
	}

	/**
	 * A cell in a Sudoku game can only store positive digits, i.e. 1...9.
	 * String lenght = rowLenght * rowlenght
	 * @param string
	 * @return
	 */
	private boolean rule1(String string) {
		// TODO Auto-generated method stub
		if( string == null ){
			return false;
		}
		
		for( int i = 0; i < string.length(); i++ ){
			if( ! Character.isDigit( string.charAt( i ) ) ){
				return false;
			}
		}
		
		
		if( string.length() != Math.pow(rowLenght, 2) ){
			return false;
		}
		
		return true;
	}
}
