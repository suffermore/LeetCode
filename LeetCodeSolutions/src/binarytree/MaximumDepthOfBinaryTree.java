package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
	//non-recursive
	public int maxDepth(TreeNode root) {
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
        		if (cur.left != null) {
        			que.add(cur.left);
        		}
        		if (cur.right != null) {
        			que.add(cur.right);
        		}
        	}
        	depth++;
        }
        return depth;
	}
	
	//recursive
	public int maxDepthII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right == null) {
            return maxDepth(root.left) + 1;
        }
        if (root.left == null && root.right != null) {
            return maxDepth(root.right) + 1;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
