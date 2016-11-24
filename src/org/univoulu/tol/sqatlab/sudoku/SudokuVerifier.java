package org.univoulu.tol.sqatlab.sudoku;

import java.util.ArrayList;

public class SudokuVerifier {

	public static int MAX_SOLUTION_SIZE = 81;

	public int verify(String candidateSolution) {

		int result = 0;

		if (!checkFirstRule(candidateSolution))
			result = -1;
		

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

		// TODO

		boolean result = true;

		return result;
	}
	
	/**
	 * extract sub grids
	 * @param candidateSolution
	 * @return arrayList that contains the 9 subgrids planed on a string
	 */
	private ArrayList<String> getSubGrid(String candidateSolution){
		
		int gridShift=3;
		int init_start=0;
		int init_end=init_start+3;
		int shift=9;
		
		ArrayList<String> subGrids= new ArrayList<String>(9);
		
		int start=init_start;
		int end=init_end;
			
		for(int k=0;k<9;k++){
			
			String tempGrid="";
			
			for(int i=0;i<3;i++){
				
				tempGrid+=candidateSolution.substring(start,end);
				
				start+=shift;
				end+=shift;
			}
			
			subGrids.add(tempGrid);
			
			start=gridShift;
			end=start+3;
			gridShift+=3;
		}
		
			
		return subGrids;
	}

}
