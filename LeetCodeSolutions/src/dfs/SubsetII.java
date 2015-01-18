package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return null;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(result, num, path, 0);
        
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, int[] num, ArrayList<Integer> path, int pos) {
        
        result.add(path);
        
        for(int i = pos; i < num.length; i++) {
            if (num[i] == num[i - 1] && i != pos) {
                continue;
            }
            path.add(num[i]);
            helper(result, num, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
