package binarytree.bst;

import binarytree.TreeNode;
import linkedlist.ListNode;

public class ConvertSortedListToBST {
private static ListNode cur;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        cur = head;
        int size = getLengthOfList(head);
        
        return buildBST(size);
    }
    
    private TreeNode buildBST(int size) {
        if (size <= 0) {
            return null;
        }
        
        TreeNode left = buildBST(size/2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = buildBST(size - size/2 - 1);
        
        root.left = left;
        root.right = right;
        return root;
    }
    
    private int getLengthOfList(ListNode head) {
        int i = 0;
        while (head!= null) {
            head = head.next;
            i++;
        }
        return i;
    }
    
    public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ConvertSortedListToBST c = new ConvertSortedListToBST();
		TreeNode root = c.sortedListToBST(head);
		System.out.println(root.val);
	}
}
