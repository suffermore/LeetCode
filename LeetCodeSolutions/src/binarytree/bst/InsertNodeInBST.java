package binarytree.bst;

import binarytree.TreeNode;

public class InsertNodeInBST {
	/**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
	//recursive
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (node.val < root.val) {
            root.left = insertNode(root.left, node);
        }
        if (node.val > root.val) {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
	
	//non-recursive
	public TreeNode insertNodeII(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
    		prev = cur;
        	if (node.val < cur.val) {
        		cur = cur.left;
        	} else {
        		cur = cur.right;
        	}
        }
        
        if (prev != null) {
        	if (node.val < prev.val) {
        		prev.left = node;
        	} else {
        		prev.right = node;
        	}
        }
        return root;
    }
	
	public static void main(String[] args) {
		InsertNodeInBST i = new InsertNodeInBST();
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(3);
		
		i.insertNodeII(root, new TreeNode(4));
	}
}
