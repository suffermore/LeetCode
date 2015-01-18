package dfs;
import java.util.ArrayList;

public class Permutation {
	/**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(result, nums, path);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> nums, ArrayList<Integer> path) {
        //deep copy a path, do not add path directly
    	if (path.size() == nums.size()) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (path.contains(nums.get(i))) {
                continue;
            }
            path.add(nums.get(i));
            helper(result, nums, path);
            //remove the one added in the same cycle, which is the last one
            path.remove(path.size() - 1);
        }
    }
}
