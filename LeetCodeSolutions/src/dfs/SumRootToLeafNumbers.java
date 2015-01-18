package dfs;

import binarytree.TreeNode;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }
    private int getSum(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        
        int sum = root.val + prev * 10;
        
        if (root.left == null && root.right == null) {
            return sum;
        }
        
        int left = getSum(root.left, sum);
        int right = getSum(root.right, sum);
        
        return left + right;
    }
}
