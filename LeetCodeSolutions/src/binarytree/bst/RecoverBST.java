package binarytree.bst;

import binarytree.TreeNode;

public class RecoverBST {
	private TreeNode prev = null;
    private TreeNode node1 = null;
    private TreeNode node2 = null;
    
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //inOrder traverse
        inOrder(root.left);
        if (prev == null) {
            //while traverse to the most left of the tree
            prev = root;
        } else {
            if (prev.val > root.val) {
                if (node1 == null) {
                    //only update when node1 is the first wrong node
                    node1 = prev;
                }
                node2 = root;
            }
            //move forword
            prev = root;
        }
        inOrder(root.right);
    }
    //better version
    private void inorderTraverse(TreeNode root) {
        if (root == null)
            return;
        inorderTraverse(root.left);
        if (prev != null) {
            if (root.val <= prev.val) {
                if (node1 == null) 
                    node1 = prev;
                node2 = root;
            }
        }
        prev = root;
        inorderTraverse(root.right);
    }
}
