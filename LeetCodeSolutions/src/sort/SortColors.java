package sort;

//problem of two pointers
public class SortColors {
	//O(n^2) method
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int left = 0;
        left = partition(A, 0, A.length - 1, 0);
        partition(A, left, A.length - 1, 1);
    }
    
    private int partition(int[] A, int left, int right, int tar) {
        while (left < right) {
            while (A[left] == tar && left < right) {
                left++;
            }
            while(A[right] != tar && left < right) {
                right--;
            }
            if (left < right) {
                swap(A, left, right);
            }
        }
        return left;
    }
    
    //O(n) method
	public void sortColorsII(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        int i = 0;
        while (i <= end) {
            if (A[i] == 0) {
                swap(A, start, i);
                start++;
                i++;
            } else if (A[i] == 2) {
                swap(A, end, i);
                end--;
                /**
                *  Do not i== now, because we still do't know the value of previous A[end], 
                *  if it is q, i++ is ok, if it is 0, 0 would be passed
                */
            } else {
                i++;
            }
        }
        
    }
    
    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    
    public static void main(String[] args) {
    	int[] A = {0,0};
		SortColors s = new SortColors();
		s.sortColors(A);
	}
}
