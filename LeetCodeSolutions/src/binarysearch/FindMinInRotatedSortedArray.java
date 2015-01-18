package binarysearch;

public class FindMinInRotatedSortedArray {
	public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        if (num[start] < num[end]) {
            return num[start];
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] < num[start]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (num[start] < num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }
	
	public static void main(String[] args) {
		int[] num = {1,2,3};
		FindMinInRotatedSortedArray f = new FindMinInRotatedSortedArray();
		System.out.println(f.findMin(num));
	}
}
