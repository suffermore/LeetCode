package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
	//non-recursive
	public ArrayList<Integer> inorderTraversalI(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curNode = root;
        while (!stack.empty() || curNode != null) {
        	while (curNode != null) {
        		stack.push(curNode);
        		curNode = curNode.left;
        	}
        	if (!stack.empty()) {
        		curNode = stack.pop();
        		result.add(curNode.val);
        		curNode = curNode.right;
        	}
        }
        return result;
	}
	
	//divide and conquer
	public ArrayList<Integer> inorderTraversalII(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        ArrayList<Integer> left = inorderTraversalII(root.left);
        result.addAll(left);
        result.add(root.val);
        ArrayList<Integer> right = inorderTraversalII(root.right);
        result.addAll(right);
        
        return result;
	}
	
	//traverse
	public ArrayList<Integer> inorderTraversalIII(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        traverse(result, root);
        return result;
    }
    private void traverse(ArrayList<Integer> result, TreeNode root) {
        if (root.left != null) {
            traverse(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            traverse(result, root.right);
        }
    }

    public static void main(String[] args) {
    	BinaryTreeInOrderTraversal b = new BinaryTreeInOrderTraversal();

		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);

		result = b.inorderTraversalI(root);
		System.out.println(result.toString());
	}
}
