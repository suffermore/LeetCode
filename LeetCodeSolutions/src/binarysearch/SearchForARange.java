package binarysearch;

public class SearchForARange {
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
	public int[] searchRange(int[] A, int target) {
        int[] border = new int[2];
        //search left border
        int left = 0;
        int right = A.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] == target) {
                right = mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] == target) {
            border[0] = left;
        } else if (A[right] == target) {
            border[0] = right;
        } else {
        	border[0] = -1;
        	border[1] = -1;
            return border;
        }
        
        //search right border
        left = 0;
        right = A.length - 1;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] == target) {
                left = mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[right] == target) {
            border[1] = right;
        } else if (A[left] == target) {
            border[1] = left;
        } else {
        	border[0] = -1;
        	border[1] = -1;
            return border;
        }
        
        return border;
    }
	public static void main(String[] args) {
		SearchForARange sr = new SearchForARange();
		int[] A = {1,2,3};
		int[] border = new int[2];
		border = sr.searchRange(A, 3);
		System.out.println(border[0]);
		System.out.println(border[1]);
	}
}
