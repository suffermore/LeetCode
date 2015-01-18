package linkedlist;

public class SortList {
	//其实就是考察list的几个基本操作
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        //find Middle of the list
        ListNode mid = findMiddle(head);
        
        //Divide list into left and right
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        //merge left and right
        return merge(left, right);
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
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
		SortList s = new SortList();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		s.sortList(head);
	}
}
