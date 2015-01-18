package binarytree;

class ResultType {
	int singlePath;
	int maxPath;
	ResultType(int singlePath, int maxPath) {
		this.singlePath = singlePath;
		this.maxPath = maxPath;
	}
}

public class BinaryTreeMaximumPathSum {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
	public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
	
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        
        //divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        //update singlePath: used for its parent node
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        //give up this node if the path sum < 0
        singlePath = Math.max(0, singlePath);
        
        //maxPath: compare children's max path
        int maxPath = Math.max(left.maxPath, right.maxPath);
        //Conquer: update maxPath - compare to new path containing the new node root
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        System.out.println("Root " + root.val + "( singlePath: " + singlePath + ", maxPath: " + maxPath + ");");
        
        return new ResultType(singlePath, maxPath);
    }
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();

		TreeNode root = new TreeNode(-1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(-4);
		root.left.right = new TreeNode(-5);
		
		b.maxPathSum(root);
	}
}
