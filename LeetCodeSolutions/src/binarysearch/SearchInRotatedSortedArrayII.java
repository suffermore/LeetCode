package binarysearch;

public class SearchInRotatedSortedArrayII {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : boolean
     */
	public boolean search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return true;
            }
            //when each element in the second half is the same with A[0]
            if (A[mid] == A[right] && A[mid] == A[left]) {
            	right = mid;
            }
            //when mid is in the left
            if (A[mid] >= A [0]) {
                if (A[mid] >= target && target >= A[left]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {//when mid is in the right
                if (target <= A[right] && A[mid] <= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (A[left] == target) {
            return true;
        }
        if (A[right] == target) {
            return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		SearchInRotatedSortedArrayII srs = new SearchInRotatedSortedArrayII();
		int[] A = {1,3,1,1,1};
		if (srs.search(A, 3)){
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
