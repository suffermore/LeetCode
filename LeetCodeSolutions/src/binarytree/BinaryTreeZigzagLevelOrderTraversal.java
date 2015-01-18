package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	
	/**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		boolean normalOrder = true;

		while (!que.isEmpty()) {
			int size = que.size();
			ArrayList<Integer> level = new ArrayList<Integer>();
			
			for (int i = 0; i < size; i++) {
				TreeNode temp = que.poll();
				if (!normalOrder) {
					level.add(0, temp.val);
				} else {
					level.add(temp.val);
				}
				
				if (temp.left != null) {
					que.add(temp.left);
				}
				if (temp.right != null) {
					que.add(temp.right);
				}
			}
			normalOrder = !normalOrder;
			result.add(level);
		}
		return result;
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
		result = b.zigzagLevelOrder(root);
		System.out.println(result.toString());
	}
}
