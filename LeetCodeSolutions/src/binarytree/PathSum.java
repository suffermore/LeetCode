package binarytree;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
        if (root.left == null && root.right == null) {
        	return sum == root.val;
        } else {
        	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
    
    public static void main(String[] args) {
		PathSum p = new PathSum();
		TreeNode root = new TreeNode(-2);
//		root.left = new TreeNode(2);
		root.right = new TreeNode(-3);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(5);
		if (p.hasPathSum(root, -5)) {
			System.out.println("Have");
		} else {
			System.out.println("Not Have");
		}
	}
}
