package binarysearch;

public class SearchInRotatedSortedArray {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
	public int search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            }
            //when mid is in the left
            if (A[mid] > A [0]) {
                if (A[mid] >= target && target >= A[left]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {//when mid is in the right
                if (target <= A[right] && A[mid] >= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (A[left] == target) {
            return left;
        }
        if (A[right] == target) {
            return right;
        }
        return -1;
    }
}
