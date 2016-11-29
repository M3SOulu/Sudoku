package org.univoulu.tol.sqatlab.sudoku;

import java.util.ArrayList;
import java.util.Iterator;

public class SudokuVerifier {

	public static int MAX_SOLUTION_SIZE = 81;

	public int verify(String candidateSolution) {

		int result = 0;

		if (!checkFirstRule(candidateSolution)) {

			result = -1;

		} else if (!checkSecondRule(candidateSolution)) {

			result = -2;

		} else if (!checkThirdRule(candidateSolution)) {

			result = -3;
			
		} else if (!checkFourthRule(candidateSolution)) {

			result = -4;
		}

		return result;
	}

	/**
	 * if first rule is respected return true, false otherwise
	 * 
	 * @param candidateSolution
	 * @return
	 */
	private boolean checkFirstRule(String candidateSolution) {

		boolean result = true;

		if (candidateSolution.length() != MAX_SOLUTION_SIZE) {

			result = false;

		} else {

			for (int i = 0; i < MAX_SOLUTION_SIZE; i++) {

				if (!Character.isDigit(candidateSolution.charAt(i))) {

					result = false;
					break;
				}

			}

		}

		return result;
	}

	/**
	 * if second rule is respected return true, false otherwise
	 * 
	 * @param candidateSolution
	 * @return
	 */
	private boolean checkSecondRule(String candidateSolution) {

		boolean result = true;

		ArrayList<String> subgridsList = getSubGrid(candidateSolution);

		Iterator<String> it = subgridsList.iterator();

		while (it.hasNext()) {

			String localGrid = it.next();

			if (checkDoubles(localGrid)) {

				result = false;
				break;
			}

		}

		return result;
	}

	/**
	 * extract sub grids
	 * 
	 * @param candidateSolution
	 *            string not null
	 * @return arrayList that contains the 9 subgrids planed on a string
	 */
	public ArrayList<String> getSubGrid(String candidateSolution) {

		// shift for the grid index
		int gridShift = 3;

		// initial start of elements' index
		int init_start = 0;

		// initial end of elements' index
		int init_end = init_start + 3;

		// shift for the elements index
		int shift = 9;

		// adjustments of gridshift when current index reach the row-grid end
		int SECOND_ROW_GRID_ADJ = 27;
		int THIRD_ROW_GRID_ADJ = 54;

		// indexes of subgrids of second and third row-grid of the main grid of
		// sudoku. Indexes start from 0 so have a decrement of 1
		int THIRD_GRID = 2;
		int SIXTH_GRID = 5;

		ArrayList<String> subGrids = new ArrayList<String>(9);

		int start = init_start;
		int end = init_end;

		for (int gridIndex = 0; gridIndex < 9; gridIndex++) {

			String tempGrid = "";

			for (int i = 0; i < 3; i++) {

				tempGrid += candidateSolution.substring(start, end);

				start += shift;
				end += shift;
			}

			subGrids.add(tempGrid);

			if (gridIndex == THIRD_GRID) {
				gridShift = SECOND_ROW_GRID_ADJ;
			} // grid row adjustments

			if (gridIndex == SIXTH_GRID) {
				gridShift = THIRD_ROW_GRID_ADJ;
			}

			start = gridShift;
			end = start + 3;
			gridShift += 3;
		}

		return subGrids;
	}

	/**
	 * if second rule is respected return true, false otherwise
	 * 
	 * @param candidateSolution
	 *            not null
	 * @return
	 */
	private boolean checkThirdRule(String candidateSolution) {

		boolean result = true;

		int rows = 9;
		int start = 0;

		String currentRow = candidateSolution.substring(start, rows);

		for (int i = 0; i < rows; i++) {

			if (checkDoubles(currentRow)) {

				result = false;
				break;

			} else {

				currentRow = currentRow.substring(start, rows);

			}

		}

		return result;
	}
	
	/**
	 * if fourth rule is respected return true, false otherwise
	 * @param cadidateSolution
	 * 				not null
	 * @return
	 */
	private boolean checkFourthRule(String cadidateSolution){
		
		boolean result=true;
		
		int rows=9;
		int colIndex=0;
		int colIndexShift=0;
		int colShift=9;
		
		for(int k=0;k<rows;k++){
			
			String currentCol="";
			
			for(int i=0;i<rows;i++){
				
				currentCol+=cadidateSolution.charAt(colIndex);
				colIndex+=colShift;
				
			}
			
			if(checkDoubles(currentCol)){
				
				result=false;
				break;
			}
			
			colIndexShift++;
			colIndex=colIndexShift;
		}
		
		return result;
	}

	/**
	 * check if there are double chars in the string
	 * 
	 * @param toCheck
	 *            not null
	 * @return true if there is at least one occurence of double char, false
	 *         otherwise.
	 */
	private boolean checkDoubles(String toCheck) {

		boolean result = false;
		int counter[] = new int[9];

		for (int i = 0; i < toCheck.length(); i++) {

			int num = Integer.parseInt(toCheck.substring(i, i + 1));
			counter[num - 1]++;

			if (counter[num - 1] >= 2) {

				result = true;
				break;
			}
		}

		return result;

	}

}
