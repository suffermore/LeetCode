package binarytree.bst;

import binarytree.TreeNode;

public class ValidBinarySearchTree {
	//new - correct even when node.val equals to Integer.MIN_VALUE or Integer.MAX_VALUE
	
	
	//old
	public boolean isValidBSTII (TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}

		return isValidBST(root.left, min, root.val)&&isValidBST(root.right, root.val, max);
	}
}
