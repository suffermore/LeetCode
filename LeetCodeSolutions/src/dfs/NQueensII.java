package dfs;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	
	public List<String[]> solveNQueens(int n) {
		
		List<String[]> result = new ArrayList<String[]>();
		if (n <= 0) {
			 return result;
		}
		
		helper(result, new ArrayList<Integer>(), n);
		
		return result;
    }

	private void helper(List<String[]> result, ArrayList<Integer> usedCols, int n) {
		if (usedCols.size() == n) {
			result.add(drawChessBoard(usedCols));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isValid(usedCols, i)) {
				usedCols.add(i);
				helper(result, usedCols, n);
				usedCols.remove(usedCols.size() - 1);
			}
		}
	}

	private boolean isValid(ArrayList<Integer> usedCols, int col) {
		for (int i = 0; i < usedCols.size(); i++) {
			if (usedCols.get(i) == col) {
				return false;
			}
			if (usedCols.size() - i == Math.abs(col - usedCols.get(i))) {
				return false;
			}
		}
		return true;
	}

	private String[] drawChessBoard(ArrayList<Integer> usedCols) {
		String[] chessboard = new String[usedCols.size()];
		
		for (int i = 0; i < usedCols.size(); i++) {
			chessboard[i] = "";
			for (int j = 0; j < usedCols.size(); j++) {
				if (usedCols.get(i) == j) {
					chessboard[i] += "Q";
				} else {
					chessboard[i] += ".";
				}
			}
		}
		
		return chessboard;
	}
	
	public static void main(String[] args) {
		NQueensII n = new NQueensII();
		System.out.println(n.solveNQueens(4).toString());
	}
}
