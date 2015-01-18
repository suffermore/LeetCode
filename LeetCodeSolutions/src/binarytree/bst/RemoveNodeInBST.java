package binarytree.bst;

import binarytree.TreeNode;

public class RemoveNodeInBST {
	/**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
    	//create dummyNode, so even if value node is root, we can delete directly
    	TreeNode dummy = new TreeNode(0);
    	dummy.left = root;
    	
    	//find parents node of the target node
    	TreeNode parents = findNode(dummy, root, value);
    	//find node, whether is is in the left or right of the parents node, or it is the root node itself
    	TreeNode tar;
    	if (parents.left != null && parents.left.val == value) {
    		tar = parents.left;
    	} else if (parents.right != null && parents.right.val == value) {
    		tar = parents.right;
    	} else {
    		//when only one node in the tree
    		return dummy.left;
    	}
    	//delete the node
    	delete(parents, tar);
    	
    	return dummy.left;
    }
	//find parents node of the target node
    private TreeNode findNode(TreeNode parents, TreeNode root, int value) {
    	if (root == null) {
    		return parents;
    	}
    	if (root.val == value) {
    		return parents;
    	}
    	if (root.val > value) {
    		return findNode(root, root.left, value);
    	} else {
    		return findNode(root, root.right, value);
    	}
    }
	//delete tar, and replace with the minimum node of the right subtree of tar
    private void delete(TreeNode parents, TreeNode tar) {
    	//when tar has only left subtree
    	if (tar.right == null) {
    		if (parents.left == tar) {
    			parents.left = tar.left;
    		}
    		if (parents.right == tar) {
    			parents.right = tar.left;
    		}
    	} else {
    		//get minimum node of right subtree, which is the most left child of tar
    		TreeNode father = tar;
    		TreeNode cur = tar.right;
    		while (cur.left != null) {
    			father = cur;
    			cur = cur.left;
    		}
    		//take cur(minimum node of right subtree) out, considering cur has no left child, so link cur's parents to his right child
    		if (father.right == cur) {
        		//special case, when cur.right has no left child
    			father.right = cur.right;
    		} else {
    			father.left = cur.right;
    		}
    		//Replace: let cur be the child of parents of tar
    		if (parents.left == tar) {
    			parents.left = cur;
    		} else {
    			parents.right = cur;
    		}
    		//link former children to new node
    		cur.left = tar.left;
    		cur.right = tar.right;
    	}
	}
    
    public static void main(String[] args) {
		RemoveNodeInBST r = new RemoveNodeInBST();
		
		TreeNode root = new TreeNode(20);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(40);
//		root.right.left = new TreeNode(35);
		
		r.removeNode(root, 20);
	}
}
