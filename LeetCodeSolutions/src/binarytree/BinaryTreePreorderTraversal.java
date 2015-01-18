package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	//non-recursive version
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            result.add(curNode.val);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return result;
    }
    
    //divide & conquer
    public ArrayList<Integer> preorderTraversalII(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        //divide
        ArrayList<Integer> left = preorderTraversalII(root.left);
        ArrayList<Integer> right = preorderTraversalII(root.right);
        //conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

	//traverse
    public ArrayList<Integer> preorderTraversalIII(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        traverse(root, result);
        return result;
    }
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return ;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
    
    public static void main(String[] args) {
		BinaryTreePreorderTraversal b = new BinaryTreePreorderTraversal();

		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		result = b.preorderTraversal(root);
		System.out.println(result.toString());
	}
}
