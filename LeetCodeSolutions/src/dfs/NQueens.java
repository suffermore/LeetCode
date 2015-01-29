package dfs;

import java.util.ArrayList;

public class NQueens {
	
	private static int sum;
	
	public int totalNQueens(int n) {
        if (n <= 1) {
        	return n;
        }
        
        sum = 0;
        
        //store which cols have been chosen in each row. i present index of row, usedCol[i] is index of col
//        int[] usedCol = new int[n];
//        helper(usedCol, 0);
        
        ArrayList<Integer> usedCols = new ArrayList<Integer>();
        helperII(usedCols, n);
        
        return sum;
    }
	
	private void helperII(ArrayList<Integer> usedCol, int n) {
		if (usedCol.size() == n) {
			sum++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isValidII(usedCol, i)) {
				usedCol.add(i);
				helperII(usedCol, n);
				usedCol.remove(usedCol.size() - 1);
			}
		}
	}
	
	private boolean isValidII(ArrayList<Integer> usedCol, int col) {
		for (int i = 0; i < usedCol.size(); i++) {
			if (usedCol.get(i) == col) {
				return false;
			}
			if (usedCol.size() - i == Math.abs(col - usedCol.get(i))) {
				return false;
			}
		}
		return true;
	}

	//use for-loop traverse row, use helper() recursive to goto next row
	private void helper(int[] usedCols, int row) {
		int len = usedCols.length;
		if (row == len) {
			sum++;
			return;
		}
		
		for (int i = 0; i < len; i++) {
			if (isValid(usedCols, row, i)) {
				usedCols[row] = i;
				helper(usedCols, row + 1);
				//here usedCols is an array, diffenrent from arraylist, no removing methold needed here
			}
		}
	}

	private boolean isValid(int[] usedCols, int row, int pos) {
		
		//Attention: it is i < row, not i < usedCols.length
		for (int i = 0; i < row; i++) {
			if (usedCols[i] == pos) {
				return false;
			}
			if ((row - i) == Math.abs(pos - usedCols[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		NQueens n = new NQueens();
		System.out.println(n.totalNQueens(4));
	}
}
