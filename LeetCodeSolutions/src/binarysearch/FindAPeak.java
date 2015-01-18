package binarysearch;

public class FindAPeak {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
	public int findPeakElement(int[] num) {
        if (num == null) {
            return -1;
        }
        if (num.length == 1) {
            return 0;
        }
        int left = 0;
        int right = num.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid == 0) {
                if (num[mid] > num[mid + 1]) {
                    return mid;
                } else {
                    return left = mid + 1;
                }
            } else if (mid == num.length - 1) {
                if (num[mid] > num[mid - 1]) {
                    return mid;
                } else {
                    return right = mid - 1;
                }
            }
            
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
                return mid;
            } else if (num[mid] > num[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		FindAPeak f = new FindAPeak();
		int[] num = {1,2};
		System.out.println(f.findPeakElement(num));
	}
}
