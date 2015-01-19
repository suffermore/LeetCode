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
    
    public int maxSubArrayII(int[] A) {
    	
        int curSum = A[0];
        int maxSum = A[0];
        
        for (int i = 1; i < A.length; i++) {
            curSum = Math.max(A[i], curSum + A[i]); //cur_sum < 0 ? A[i] : cur_sum + A[i]
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
	public static void main(String[] args) {
		int[] A = {-1, 2};
		
		MaxSubArray m = new MaxSubArray();
		System.out.println(m.maxSubArray(A));
	}
}
