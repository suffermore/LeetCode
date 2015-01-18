package binarytree.bst;

import binarytree.TreeNode;

public class convertSortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
        if (num== null) {
            return null;
        }
        return buildBST(num, 0, num.length - 1);
    }
    private TreeNode buildBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildBST(num, start, mid - 1);
        root.right = buildBST(num, mid + 1, end);
        return root;
    }
}
