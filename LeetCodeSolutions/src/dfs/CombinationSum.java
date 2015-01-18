package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	/**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
	public ArrayList<ArrayList<Integer>> combinationSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(result, nums, path, 0, target);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result, int[] nums, ArrayList<Integer> path, int pos, int remainder) {
        if (remainder == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (remainder - nums[i] < 0) {
                break;
            }
            path.add(nums[i]);
            helper(result, nums, path, i, remainder - nums[i]);
            path.remove(path.size() - 1);
        }
    }
    
    public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] nums = {1};
        ArrayList<ArrayList<Integer>> result = cs.combinationSum(nums, 1);
        System.out.println(result.toString());
	}
}
