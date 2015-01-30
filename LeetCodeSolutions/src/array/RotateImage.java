package array;

public class RotateImage {
	
	public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        //count is the order of circle
        int count = 0;
        int len = matrix.length;
        while (count < matrix.length / 2) {
            
            int j = count;
            while (j < matrix.length - count - 1) {
                int temp = matrix[count][j];
                
                matrix[count][j] = matrix[len - 1 - j][count];
                matrix[len - 1 - j][count] = matrix[len - 1 - count][len - 1 - j];
                matrix[len - 1 - count][len - 1 - j] = matrix[j][len - 1 - count];
                matrix[j][len - 1 - count] = temp;
                
                j++;
            }
            
            count++;
        }
    }
	
	public static void main(String[] args) {
		RotateImage r = new RotateImage();
		int[][] matrix = {{1, 2}, {3, 4}};
		r.rotate(matrix);
	}
}
