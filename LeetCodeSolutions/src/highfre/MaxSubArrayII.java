package highfre;

public class MaxSubArrayII {
	
	//O(n^2)
	public int maxSubArray(int[] A) {
		if (A == null || A.length < 2) {
			return 0;
		}
		
		int profit = 0;
		for (int i = 0; i < A.length; i++) {
			profit = Math.max(profit, divMaxSubArray(A, 0, i) + divMaxSubArray(A, i+1, A.length - 1));
		}
		return profit;
	}
	
	private int divMaxSubArray(int[] A, int start, int end) {
		int cur_max = 0;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			max = Math.max(max, cur_max + A[i]);
			cur_max = Math.max(cur_max + A[i], 0);
		}
		return max;
	}
	
}
