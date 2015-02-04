package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationII {

	/**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        helper(result, path, nums, visited);
        return result;
    }

	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int[] nums, boolean[] visited) {
		
		if (path.size() == nums.length) {
			result.add(new ArrayList<Integer>(path));
			return ;
		}
		
		for (int i = 0; i < nums.length; i++) {
			
			if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
				continue;
			}
			if (!visited[i]) {
				path.add(nums[i]);
				visited[i] = true;
				helper(result, path, nums, visited);
				path.remove(path.size() - 1);
				visited[i] = false;
			}
		}
	}
    
    public static void main(String[] args) {
		PermutationII p = new PermutationII();
		int[] nums = {-1,-1,3,-1};
		p.permuteUnique(nums);
	}
}
