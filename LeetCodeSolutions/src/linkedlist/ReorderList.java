package linkedlist;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
        ListNode mid = findMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        right = reverse(right);
        merge(left, right);
//        mergeII(left, right);
    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    private void merge(ListNode left, ListNode right) {
    	 ListNode dummy = new ListNode(0);
         int index = 0;
         while (left != null && right != null) {
        	 if (index % 2 == 0) {
        		 dummy.next = left;
        		 left = left.next;
        	 } else {
        		 dummy.next = right;
        		 right = right.next;
        	 }
        	 dummy = dummy.next;
        	 index++;
         }
         if (left != null) {
        	 dummy.next = left;
         } else {
        	 dummy.next = right;
         }
	}
    
    private void mergeII(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        while (l1 != null && l2 != null) {
        	dummy.next = l1;
            l1 = l1.next;
            dummy.next.next = l2;
            l2 = l2.next;
            dummy = dummy.next.next;
        }
        if (l1 != null) {
        	dummy.next = l1;
        }
        if (l2 != null) {
        	dummy.next = l2;
        }
    }
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	
		ReorderList r = new ReorderList();
		r.reorderList(head);
		
	}
}
