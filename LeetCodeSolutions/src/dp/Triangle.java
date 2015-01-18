package dp;

import java.util.List;

public class Triangle {
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[][] matrix = new int[n][n];
        /**
         * Why Bottom-Up? if up-to-bot: 
         * then we have to compare n element of nth level to choose a minimum; 
         * it's better to calculate bot-to-up
         */
        //Initialize
        for (int i = 0; i < n; i++) {
            matrix[n - 1][i] = triangle.get(n - 1).get(i);
        }
        //dynamic programming Bottom-Up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return matrix[0][0];
    }
}
