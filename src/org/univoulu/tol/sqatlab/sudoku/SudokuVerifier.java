package org.univoulu.tol.sqatlab.sudoku;

import java.util.ArrayList;
import java.util.Iterator;

public class SudokuVerifier {

	public static int MAX_SOLUTION_SIZE = 81;

	public int verify(String candidateSolution) {

		int result = 0;

		if (!checkFirstRule(candidateSolution)){
			
			result = -1;
			
		}else if(!checkSecondRule(candidateSolution)){
			
			result= -2;
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
		
		int counter[];
		
		boolean result=true;
				
		ArrayList<String> subgridsList= getSubGrid(candidateSolution);
		
		Iterator<String> it= subgridsList.iterator();
		
		while(it.hasNext()){
			
			counter= new int[9];
			String localGrid= it.next();
			
			for(int i=0;i<localGrid.length();i++){
				
				int num= Integer.parseInt(localGrid.substring(i, i+1));
				counter[num-1]++;
				
				if(counter[num-1]>=2){
					
					result=false;
					break;
				}
			}
			
			
		}

		return result;
	}
	
	/**
	 * extract sub grids
	 * @param candidateSolution string  not null
	 * @return arrayList that contains the 9 subgrids planed on a string
	 */
	public ArrayList<String> getSubGrid(String candidateSolution){
		
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
			
			if(k==2){gridShift=27;} // grid row adjustments
			
			if(k==5){gridShift=54;}
						
			start=gridShift;
			end=start+3;
			gridShift+=3;
		}
		
			
		return subGrids;
	}

}
