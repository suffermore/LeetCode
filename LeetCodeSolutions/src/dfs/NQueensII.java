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
			return ;
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
		int curRow = usedCols.size();
		
		for (int i = 0; i < curRow; i++) {
			if (usedCols.get(i) == col) {
				return false;
			}
			if (curRow - i == Math.abs(col - usedCols.get(i))) {
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
				if (j == usedCols.get(i)) {
					chessboard[i] += "Q";
				} else {
					chessboard[i] += ".";
				}
			}
		}
		
		return chessboard;
	}
}
