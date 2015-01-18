package dp;

public class UniquePath {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] matrix = new int[m][n];
        //Initialize
        for (int i = 0; i < m; i++) {
        	matrix[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
        	matrix[0][i] = 1;
        }
        //dynamic programming
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
        	}
        }
        return matrix[m - 1][n - 1];
    }
}
