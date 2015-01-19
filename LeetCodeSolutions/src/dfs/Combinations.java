package dfs;

import java.util.ArrayList;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n == 0 || k == 0) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(result, path, n, k, 1);
        
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int n, int k, int pos) {
        if (path.size() == k ) {
            result.add(new ArrayList<Integer>(path));
        }
        for (int i = pos; i <= n; i++) {
            path.add(i);
            helper(result, path, n, k , i+1);
            path.remove(path.size() - 1);
        }
    }
}
