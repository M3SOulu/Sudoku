package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	private int rowLenght;
	
	public SudokuVerifier( int rowLenght ){
		this.rowLenght = rowLenght;
	}
	
	/**
	 * verify if sudoku game is correct
	 * @param candidateSolution string that contains sudoku game values row-oredered
	 * @return a positive values if correct, a negative value instead
	 */
	public int verify(String candidateSolution) {
		
		if( ! rule1( candidateSolution ) ){
			return -1;
		}
		
		if( ! rule2( candidateSolution ) ){
			return -2;
		}
		
		if( ! rule3( candidateSolution ) ){
			return -3;
		}
		
		if( ! rule4( candidateSolution ) ){
			return -4;
		}
		
		
		return 0;
	}
	
	/**
	 * A digit can appear only once in the columns of the global grid.
	 * @param string
	 * @return true if correct
	 */
	private boolean rule4(String string){
		String subString;
		
		for( int i = 0; i < rowLenght; i++ ){
			subString = "";
			//get global column
			for( int j = i; j <= (rowLenght *(rowLenght-1) +i); j+=rowLenght ){
				subString += string.substring( j, j+1 );
			}
			
			if( ! containsOnlyDifferentValues( subString ) ){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * A digit can appear only once in the rows of the global grid.
	 * @param string
	 * @return true if correct
	 */
	private boolean rule3(String string){
		String subString;
		int j = 0;
		
		for( int i = 0; i < rowLenght; i++ ){
			//get global row
			subString = string.substring(j, j+rowLenght);
			
			if( ! containsOnlyDifferentValues( subString ) ){
				return false;
			}
			//increment j for next global row
			j += rowLenght;
		}
		
		return true;
	}
	
	
	
	/**
	 * All digits appear only once in a sub-grid, i.e. they cannot repeat.
	 * @param string
	 * @return true if correct
	 */
	private boolean rule2( String string ){
		int j = 0;
		String subGrid;
		//get sub-grid lenght
		Double subGridLenght = Math.sqrt( rowLenght );
		int n = subGridLenght.intValue();
		
		for( int i = 0; i < rowLenght; i++ ){
			//get sub-grid values
			subGrid = string.substring( j, (j+n)) +
					string.substring((j+rowLenght), (j+rowLenght+n)) +
					string.substring((j+rowLenght*2), (j+rowLenght*2+n));
			
			//control sub-grid values
			if( ! containsOnlyDifferentValues( subGrid ) ){
				return false;
			}
			
			//increment j for next sub-grid
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
	 * 
	 * @param string
	 * @return true if string is correct
	 */
	private boolean rule1(String string) {
		// TODO Auto-generated method stub
		if( string == null ){
			return false;
		}
		
		//only digit allowed
		for( int i = 0; i < string.length(); i++ ){
			if( ! Character.isDigit( string.charAt( i ) ) ){
				return false;
			}
		}
		
		//String lenght = rowLenght * rowlenght
		if( string.length() != Math.pow(rowLenght, 2) ){
			return false;
		}
		
		return true;
	}
}
