package binarytree;

public class PopulatingNextRightPointersInEachNode {
	
	public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode cur;
        while (root.left != null) {
            cur = root;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            root = root.left;
        }
    }
	
	//solution II
	public void connectII(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode parent = root;
		TreeLinkNode nextLv = parent.left;
		while (parent != null && nextLv != null) {
			TreeLinkNode prev = null;
			while (parent != null) {
				if (prev == null) {
					prev = parent.left;
				} else {
					prev.next = parent.left;
					prev = prev.next;
				}
				prev.next = parent.right;
				prev = prev.next;
				parent = parent.next;
			}
			parent = nextLv;
			nextLv = parent.left;
		}
	}
}
