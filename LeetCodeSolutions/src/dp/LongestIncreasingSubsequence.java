package dp;

public class LongestIncreasingSubsequence {
	/**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
        	return 0;
        }
        //f[i] means in the first i elements, the max length end with num[i -1]
        int[] f = new int[num.length];
        
        int max = 1;
        for (int i = 0; i < num.length; i++) {
        	//each time there are at one element end with itself which is iteself
        	f[i] = 1;
        	for (int j = 0; j < i; j++) {
        		
        		if (num[j] < num[i]) {
        			f[i] = Math.max(f[i], f[j] + 1);
        		}
        	}
        	max = Math.max(max, f[i]);
        }
        
        //if it need increasing or decreasing, just do it again reversely
//        max = 1;
//        f = new int[num.length];
//        for (int i = 0; i < num.length; i++) {
//        	f[i] = 1;
//        	for (int j = 0; j < i; j++) {
//        		if (num[j] > num[i]) {
//        			f[i] = Math.max(f[i], f[j] + 1);
//        		}
//        	}
//        	max = Math.max(max, f[i]);
//        }
        return max;
    }
}
