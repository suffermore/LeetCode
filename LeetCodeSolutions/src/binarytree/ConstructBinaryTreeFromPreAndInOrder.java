package binarytree;

public class ConstructBinaryTreeFromPreAndInOrder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return myBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode myBuildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        
        //1st node in current preorder array is the root in current nodes
        TreeNode root = new TreeNode(preorder[prestart]);
        
        //divide inorder into two parts by 1st element in current Preorder Array
        int position = findPosition(inorder, instart, inend, preorder[prestart]);
        
        root.left = myBuildTree(preorder, prestart + 1,  prestart + (position - instart), inorder, instart, position - 1);
        root.right = myBuildTree(preorder, preend - (inend - position - 1), preend, inorder, position + 1, inend);
        
        return root;
    }
    
    //find index of key in array whose index range from start to end
    private int findPosition (int[] arr, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
		int[] preorder = {-1};
		int[] inorder = {-1};
		
		ConstructBinaryTreeFromPreAndInOrder c = new ConstructBinaryTreeFromPreAndInOrder();
		TreeNode root = c.buildTree(preorder, inorder);
		
		System.out.println(root.val);
    	
	}
}
