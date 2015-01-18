package dp;

public class UniquePathII {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
    		return 0;
    	}
       int col = obstacleGrid.length;
       int row = obstacleGrid[0].length;
       int[][] matrix = new int[col][row];
       
       //Initialize
       for (int i = 0; i < row; i++) {
    	   if (obstacleGrid[0][i] == 1) {
    		   // no need to write as matrix[0][i] = 0; cause it equals to 0 when initialized
    		   break;
    	   } else {
    		   matrix[0][i] = 1;
    	   }
       }
       for (int i = 0; i < col; i++) {
    	   if (obstacleGrid[i][0] == 1) {
    		   break;
    	   } else {
    		   matrix[i][0] = 1;
    	   }
       }
       //dynamic programming
       for (int i = 1; i < col; i++) {
    	   for (int j = 1; j < row; j++) {
    		   if (obstacleGrid[i][j] == 1) {
    			   matrix[i][j] = 0;
    		   } else {
    			   matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
    		   }
    	   }
       }
       return matrix[col - 1][row - 1];
    }
}
