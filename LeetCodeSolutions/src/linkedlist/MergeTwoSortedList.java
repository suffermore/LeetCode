package linkedlist;

public class MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		MergeTwoSortedList m = new MergeTwoSortedList();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(5);
		l1.next.next.next = new ListNode(7);
		l1.next.next.next.next = new ListNode(9);
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(8);
		l2.next.next = new ListNode(11);
		m.mergeTwoLists(l1, l2);
	}
}
