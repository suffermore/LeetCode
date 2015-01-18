package binarytree;

public class PopulatingNextRightPointersInEachNodeII {
	
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		TreeLinkNode next = root.next;
		
		while (next != null) {
			if (next.left != null) {
				next = next.left;
				break;
			}
			if (next.right != null) {
				next = next.right;
				break;
			}
			next = next.next;
		}
		
		if (root.right != null) {
			root.right.next = next;
		}
		
		if (root.left != null) {
			root.left.next = (root.right == null) ? next : root.right;
		}

		connect(root.right);
		connect(root.left);
	}
	public void connectII(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode parent = root;
        TreeLinkNode pre;
        TreeLinkNode next;
        while (parent != null) {
            pre = null;
            next = null;
            while (parent != null) {
                if (next == null){
                    next = (parent.left != null) ? parent.left: parent.right;
                }

                if (parent.left != null){
                    if (pre != null) {
                        pre.next = parent.left;
                        pre = pre.next;
                    } else {
                        pre = parent.left;
                    }
                }

                if (parent.right != null) {
                    if (pre != null) {
                        pre.next = parent.right;
                        pre = pre.next;
                    } else {
                        pre = parent.right;
                    }
                }
                parent = parent.next;
            }
            parent = next;
        }
    }
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.right.right = new TreeLinkNode(5);
		
		PopulatingNextRightPointersInEachNodeII p = new PopulatingNextRightPointersInEachNodeII();
		p.connect(root);
		
		System.out.println(root.val);
	}
}
