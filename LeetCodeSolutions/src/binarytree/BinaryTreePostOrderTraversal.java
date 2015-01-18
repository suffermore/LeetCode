package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
	//non-recursive version
	public ArrayList<Integer> postorderTraversalI(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode curNode = root;
        TreeNode popedNode = null;
        while (!stack.empty()) {
        	while (curNode.left != null) {
        		stack.push(curNode.left);
        		curNode = curNode.left;
        	}
        	if (stack.peek().right == null || stack.peek().right == popedNode) {
        		popedNode = stack.pop();
        		result.add(popedNode.val);
        	} else {
        		curNode = stack.peek().right;
	        	stack.push(stack.peek().right);
        	}
        }
        return result;
	}
	
	//divide and conquer
	public ArrayList<Integer> postorderTraversalII(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        //Divide
        ArrayList<Integer> left = postorderTraversalII(root.left);
        ArrayList<Integer> right = postorderTraversalII(root.right);
        //Conquer
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        
        return result;
    }
	//traverse
	public ArrayList<Integer> postorderTraversalIII(TreeNode root) {
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
        traverse(root.left, result);
        traverse(root.right, result);
        result.add(root.val);
    }
    
    public static void main(String[] args) {
    	BinaryTreePostOrderTraversal b = new BinaryTreePostOrderTraversal();

		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(5);

		result = b.postorderTraversalI(root);
		System.out.println(result.toString());
	}
}
