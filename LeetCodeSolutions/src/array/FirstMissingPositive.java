package array;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 0;
        }
        
        for (int i = 0; i < A.length; i++) {
            while (A[i] <= A.length && A[i] > 0 && A[i] != (i+1)) {
                int tmp = A[A[i]-1];
                //when A[i] == A[A[i] - 1], not to swap, or it would cause endless loop.
                if (tmp == A[i]) {
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
        
        for (int i = 0; i < A.length; i ++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}
