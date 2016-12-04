package org.univoulu.tol.sqatlab.sudoku;

import java.util.ArrayList;

public class SudokuVerifier {

	public int verify(String candidateSolution) {
		// Return 0: means it is a valid Sudoku solution
		// Return -1: means it is violating Rule #1
		// Return -2: means it is violating Rule #2
		// Return -3: means it is violating Rule #3
		// Return -4: means it is violating Rule #4
		ArrayList<Character> posNum = new ArrayList<Character>();
		posNum.add('1');
		posNum.add('2');
		posNum.add('3');
		posNum.add('4');
		posNum.add('5');
		posNum.add('6');
		posNum.add('7');
		posNum.add('8');
		posNum.add('9');
		StringBuffer bufferOne = new StringBuffer(candidateSolution.length() / 3);
		StringBuffer bufferTwo = new StringBuffer(candidateSolution.length() / 3);
		StringBuffer bufferThree = new StringBuffer(candidateSolution.length() / 3);
		ArrayList<Character> subGrid = new ArrayList<Character>(9);
		ArrayList<Character> subGrid1 = new ArrayList<Character>(9);
		ArrayList<Character> subGrid2 = new ArrayList<Character>(9);
		ArrayList<Character> row = new ArrayList<Character>(9);
		ArrayList<Character> column = new ArrayList<Character>(9);

		// Control R1
		for (int i = 0; i < candidateSolution.length(); i++) {
			char a = candidateSolution.charAt(i);
			if (a == '-' && !(posNum.contains(a))) {
				return -1;
			}

		}

		// Divide the string candidateSolution in 3 substring
		for (int j = 0; j < candidateSolution.length(); j++) {
			if (j < 27) {
				bufferOne.append(candidateSolution.charAt(j));
			} else if (j >= 27 && j < 54) {
				bufferTwo.append(candidateSolution.charAt(j));
			} else if (j >= 54) {
				bufferThree.append(candidateSolution.charAt(j));
			}
		}

		// Control R2
		for (int z = 0; z < 3; z++) {
			String moment = null;
			if (z == 0) {
				moment = String.valueOf(bufferOne);
			} else if (z == 1) {
				moment = String.valueOf(bufferTwo);
			} else if (z == 2) {
				moment = String.valueOf(bufferThree);
			}
			for (int l = 0; l < 27; l = l + 9) {
				char a = moment.charAt(l);
				char b = moment.charAt(l + 1);
				char c = moment.charAt(l + 2);
				char d = moment.charAt(l + 3);
				char e = moment.charAt(l + 4);
				char f = moment.charAt(l + 5);
				char g = moment.charAt(l + 6);
				char h = moment.charAt(l + 7);
				char i = moment.charAt(l + 8);
				if (subGrid.contains(a) || subGrid.contains(b) || subGrid.contains(c) || a == b || b == c || a == c) {
					return -2;
				} else {
					subGrid.add(a);
					subGrid.add(b);
					subGrid.add(c);
				}
				if (subGrid1.contains(d) || subGrid1.contains(e) || subGrid1.contains(f) || d == e || e == f
						|| d == f) {
					return -2;
				} else {
					subGrid1.add(d);
					subGrid1.add(e);
					subGrid1.add(f);
				}
				if (subGrid2.contains(g) || subGrid2.contains(h) || subGrid2.contains(i) || g == h || h == i
						|| g == i) {
					return -2;
				} else {
					subGrid2.add(g);
					subGrid2.add(h);
					subGrid2.add(i);
				}
			}
			subGrid.clear();
			subGrid1.clear();
			subGrid2.clear();
		}

		// Control R3
		for (int m = 0; m < candidateSolution.length(); m++) {
			char h = candidateSolution.charAt(m);
			if (row.contains(h)) {
				return -3;
			} else {
				row.add(h);
			}
			if (m == 8 || m == 17 || m == 26 || m == 35 || m == 44 || m == 53 || m == 62 || m == 71) {
				row.clear();
			}
		}
		
		// Control R4
		for (int n = 0; n < candidateSolution.length(); n = n + 9) {
			char character = candidateSolution.charAt(n);
			if (column.contains(character)){
				return -4;
			} else {
				column.add(character);
			}
			if (n == 72){
				column.clear();
				n = 1;
			} else if (n == 73) {
				column.clear();
				n = 2;
			} else if (n == 74) {
				column.clear();
				n = 3;
			} else if (n == 75) {
				column.clear();
				n = 4;
			} else if (n == 76) {
				column.clear();
				n = 5;
			} else if (n == 77) {
				column.clear();
				n = 6;
			} else if (n == 78) {
				column.clear();
				n = 7;
			} else if (n == 79) {
				column.clear();
				n = 8;
			}
		}

		return 0;
	}
}
