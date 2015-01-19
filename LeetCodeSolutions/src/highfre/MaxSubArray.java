package highfre;

public class MaxSubArray {
	
	public int maxSubArray(int[] A) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {

            maxSum = Math.max(maxSum, curSum + A[i]);
            curSum = Math.max(0, curSum + A[i]);
            
        }
        return maxSum;
    }
	
	public static void main(String[] args) {
		int[] A = {-1, 2};
		
		MaxSubArray m = new MaxSubArray();
		System.out.println(m.maxSubArray(A));
	}
}
