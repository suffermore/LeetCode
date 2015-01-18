package binarytree;

public class SymmetricTree {
	//non-recursive
	
	//recursive
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymtTree(root.left, root.right);
    }
	private boolean isSymtTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
		    return true;
		}
		if (p == null || q == null) {
		    return false;
		}
		if (p.val != q.val) {
		    return false;
		}
		//different from SameTree, here we compare one's left tree with another's right tree
		return isSymtTree(p.left, q.right) && isSymtTree(p.right, q.left);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		SymmetricTree s = new SymmetricTree();
		if (s.isSymmetric(root)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
