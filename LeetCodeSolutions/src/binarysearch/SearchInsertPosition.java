package binarysearch;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        //search the first number that larger than target
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
        //better decision
        if (A[left] >= target) {
            return left;
        } else if (A[right] >= target) {
            return right;
        } else {
            return right + 1;
        }
        //another one
//        if (A[right] == target) {
//            return right;
//        } else if (A[right] < target) {
//            return right + 1;
//        } else if (A[left] >= target) {
//            return left;
//        } else {
//            return right;
//        }
    }
}
