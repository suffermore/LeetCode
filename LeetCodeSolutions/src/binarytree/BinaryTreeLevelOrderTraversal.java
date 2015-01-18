package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	/**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		
		while (!que.isEmpty()) {
			int size = que.size();
			ArrayList<Integer> level = new ArrayList<Integer>();
			
			//poll all nodes of last level out, and put their children in
			for (int i = 0; i < size; i++) {
				TreeNode temp = que.poll();
				level.add(temp.val);
				
				if (temp.left != null) {
					que.add(temp.left);
				}
				if (temp.right != null) {
					que.add(temp.right);
				}
			}
			result.add(level);
		}
		return result;
    }
}
