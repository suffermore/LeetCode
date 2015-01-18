package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
	/**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(result, num, path, 0, target);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result, int[] num, ArrayList<Integer> path, int pos, int remainder) {
        if (remainder == 0) {
            result.add(new ArrayList<Integer>(path));
        }
        for (int i = pos; i < num.length; i++) {
        	//discard if there are duplicates with num[pos]
            if (i != pos && num[i] == num[i - 1]){
                continue;
            }
            //break if remainder is too large to continue;
            if (remainder - num[i] < 0){
                break;
            } else {
                path.add(num[i]);
                helper(result, num, path, i + 1, remainder - num[i]);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
		CombinationSumII cs = new CombinationSumII();
		int[] nums = {1,1,2,5,6,7,10};
        ArrayList<ArrayList<Integer>> result = cs.combinationSum2(nums, 8);
        System.out.println(result.toString());
	}
}
