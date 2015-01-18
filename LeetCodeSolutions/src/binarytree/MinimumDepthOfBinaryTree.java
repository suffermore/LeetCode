package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
	//non-recursive
	public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        int depth = 0;
        while (!que.isEmpty()) {
        	int size = que.size();
        	for (int i = 0; i < size; i++) {
            	TreeNode cur = que.poll();
        		if (cur.left == null && cur.right == null) {
        			return depth + 1;
        		}
        		if (cur.right != null) {
        			que.add(cur.right);
        		}
        		if (cur.left != null) {
        			que.add(cur.left);
        		}
        	}
        	depth++;
        }
        return depth;
	}
	
	//recursive
	public int minDepthII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(3);
//		root.right.right = new TreeNode(5);
//		root.left.left.left = new TreeNode(4);
//		root.left.left.left.left = new TreeNode(5);
		
		MinimumDepthOfBinaryTree m = new MinimumDepthOfBinaryTree();
		System.out.println(m.minDepth(root));
	}
}
