package dfs;

public class NQueens {
	
	private static int sum;
	
	public int totalNQueens(int n) {
        if (n <= 1) {
        	return n;
        }
        //store which cols have been chosen in each row. i present index of row, usedCol[i] is index of col
        int[] usedCol = new int[n];
        sum = 0;
        helper(usedCol, 0);
        
        return sum;
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
