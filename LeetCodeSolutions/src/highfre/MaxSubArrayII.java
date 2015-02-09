package highfre;

public class MaxSubArrayII {
	
	//O(n)
	public int maxSubArray(int[] A) {
		if (A == null || A.length < 2) {
			return 0;
		}
		
		//left
		int[] left = new int[A.length];
		left[0] = A[0];
		int cur_sum = A[0];
		for (int i = 1; i < A.length; i++) {
			cur_sum = Math.max(A[i], cur_sum + A[i]);	//cur_sum < 0 ? A[i] : cur_sum + A[i]
			left[i] = Math.max(left[i-1], cur_sum);
		}
		
		//right
		int[] right = new int[A.length];
		right[A.length - 1] = A[A.length - 1];
		cur_sum = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			cur_sum = Math.max(A[i], cur_sum + A[i]);
			right[i] = Math.max(right[i + 1], cur_sum);
		}
		
		//get max
		int profit = Integer.MIN_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			profit = Math.max(profit, left[i] + right[i + 1]);
		}
		return profit;
	}
	
	//O(n^2)
	public int maxSubArrayII(int[] A) {
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
		int cur_sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			max = Math.max(max, cur_sum + A[i]);
			cur_sum = Math.max(cur_sum + A[i], 0);
		}
		return max;
	}
}