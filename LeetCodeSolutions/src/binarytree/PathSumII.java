package binarytree;

import java.util.ArrayList;

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		helper (result, path, root, sum);
		
		return result;
    }
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, TreeNode root, int sum) {
		if (root == null) {
			return ;
		}
		//add only when traverse to leaf node
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				path.add(root.val);
				result.add(new ArrayList<Integer>(path));
				path.remove(path.size() - 1);
			}
			return ;
		}
		path.add(root.val);
		helper(result, path, root.left, sum - root.val);
		helper(result, path, root.right, sum - root.val);
		path.remove(path.size());
		//after remove this root, path could then go to his brother node
	}
}
