package binarytree;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        return getAncestor(root, A, B);
    }
	public TreeNode getAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || root == A || root == B) {
			return root;
		}
		
		//Divide
		TreeNode left = getAncestor(root.left, A, B);
		TreeNode right = getAncestor(root.right, A, B);
		
		//Conquer
		if (left != null && right != null) {
			return root;
		} else if (left != null) {
			return left;
		} else if (right != null) {
			return right;
		} else {
			return null;
		}
	}
}
