package dfs;

import binarytree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	
	private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        
        TreeNode right = root.right;
        
        flatten(root.left);
        //cannot write as flatten(root.right), because after process left part, root has been changed.
        flatten(right);
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		FlattenBinaryTreeToLinkedList f = new FlattenBinaryTreeToLinkedList();
		f.flatten(root);
	}
}
