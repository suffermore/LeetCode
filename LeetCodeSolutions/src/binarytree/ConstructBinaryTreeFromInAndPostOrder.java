package binarytree;

public class ConstructBinaryTreeFromInAndPostOrder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
         if (instart > inend) {
             return null;
         }
         
         TreeNode root = new TreeNode(postorder[postend]);
         
         int position = findPosition(inorder, instart, inend, postorder[postend]);
         
         root.left = myBuildTree(inorder, instart, position - 1, postorder, poststart, poststart + (position - instart) - 1);
         root.right = myBuildTree(inorder, position + 1, inend, postorder, poststart + (position - instart), postend - 1);
         
         return root;
    }
    
    private int findPosition(int[] array, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
