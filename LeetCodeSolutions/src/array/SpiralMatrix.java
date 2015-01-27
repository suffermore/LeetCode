package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> rst = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return rst;
		}
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int count = 0;
		//output one circle each time in while
		while (count * 2 < rows && count * 2 < cols) {
			//output four sides
			for (int i = count; i < cols - count; i++) {
				rst.add(matrix[count][i]);
			}
			for (int i = count + 1; i < rows - count; i++) {
				rst.add(matrix[i][cols - 1 - count]);
			}
			
			//check if there is only one row / col left
			if (rows - count * 2 == 1 || cols - count * 2 == 1) {
				break;
			}
			
			for (int i = cols - 2 - count; i >= count; i--) {
				rst.add(matrix[rows - 1 - count][i]);
			}
			for (int i = rows - 2 - count; i > count; i--) {
				rst.add(matrix[i][count]);
			}
			
			//push towards inside
			count++;
		}
		
		return rst;
    }
	
	public static void main(String[] args) {
//		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8 , 9}, {10, 11, 12}};
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		SpiralMatrix s = new SpiralMatrix();

		List<Integer> rst = new ArrayList<Integer>();
		rst = s.spiralOrder(matrix);
		
		System.out.println(rst.toString());
	}
}
