package dp;

import java.util.HashMap;

public class LongestConsecutiveSubsequence {

	/**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int max = 1;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int num: nums) {
        	hm.put(num, 1);
        	//1 means this num has not been get out
        }
        for (int i = 0; i < nums.length; i++) {
        	if (hm.get(nums[i]) == 0) {
        		continue;
        	} else {
        		int cur_max = 1;
        		int temp = nums[i];
        		while (hm.containsKey(temp + 1)) {
        			temp++;
        			hm.put(temp, 0);
        			cur_max++;
        		}
        		temp = nums[i];
        		while (hm.containsKey(temp - 1)) {
        			temp--;
        			hm.put(temp, 0);
        			cur_max++;
        		}
        		max = Math.max(cur_max, max);
        	}
        }
        return max;
    }
    
    public static void main(String[] args) {
		LongestConsecutiveSubsequence l = new LongestConsecutiveSubsequence();
		int[] a = {0, -1};
		System.out.println(l.longestConsecutive(a));
	}
}
