package binarytree.bst;

import java.util.Stack;

import binarytree.TreeNode;

/**
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */

public class ImplementIteratorOfBST {
	private Stack<TreeNode> stack;
	
    public ImplementIteratorOfBST(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode tempNode = root;
        if(root!=null) {
            while(tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode tempNode = node.right;
        if(tempNode!=null){
            while(tempNode!=null){
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
        }
        return node.val;
    }
}
