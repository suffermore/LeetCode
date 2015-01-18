package binarysearch;

public class SearchA2DMatrix {
	/**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
	public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int valueofMid = matrix[mid / cols][mid % cols];
            if (valueofMid == target) {
                return true;
            } else if (valueofMid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
