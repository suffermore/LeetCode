package sort;

//problem of two pointers
public class SortColors {
	
	public void sortColors(int[] A) {
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
}
