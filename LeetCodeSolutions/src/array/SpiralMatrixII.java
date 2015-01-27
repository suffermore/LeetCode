package array;

public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
		if (n <= 0) {
	        return null;
	    }
		
		int[][] matrix = new int[n][n];
		
		int count = 0;
		int num = 1;
		while (count * 2 < n) {
			//fill four sides in order each time
			for (int i = count; i < n - count; i++) {
				matrix[count][i] = num++;
			}
			for (int i = count + 1; i < n - count;i++) {
				matrix[i][n - count - 1] = num++;
			}
			
			//stop if there is only one row or col left
			if (n - count * 2 == 1) {
				break;
			}
			
			for (int i = n - count - 2; i >= count; i--) {
				matrix[n - count - 1][i] = num++;
			}
			for (int i = n - count - 2; i > count; i--) {
				matrix[i][count] = num++;
			}
			
			count++;
		}
		
		return matrix;
    }
	
	public static void main(String[] args) {
		SpiralMatrixII s = new SpiralMatrixII();
		s.generateMatrix(3);
	}
}
