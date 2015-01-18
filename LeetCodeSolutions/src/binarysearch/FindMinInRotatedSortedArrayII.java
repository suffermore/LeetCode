package binarysearch;

public class FindMinInRotatedSortedArrayII {
	//special: {10, 1, 10, 10, 10}
	public int findMin(int[] num) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        return min;
    }
}
