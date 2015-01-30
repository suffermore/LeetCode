package dfs;

import java.util.ArrayList;

public class NQueens {
	
	private static int sum;
	
	public int totalNQueens(int n) {
		sum = 0;
		ArrayList<Integer> used = new ArrayList<Integer>();
		helper(used, n, 0);
		
		return sum;
	}
	
	private void helper(ArrayList<Integer> used, int n, int row) {
		if (used.size() == n) {
			sum++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isValid(used, i)) {
				used.add(i);
				helper(used, n, i + 1);
				used.remove(used.size() - 1);
			}
		}
	}
	
	private boolean isValid(ArrayList<Integer> used, int col) {
		
		int curRow = used.size();
				
		for (int i = 0; i < curRow; i++) {
			if (used.get(i) == col) {
				return false;
			}
			if (curRow - i == Math.abs(used.get(i) - col)) {
				return false;
			}
		}
		return true;
	}
}
