package linkedlist;

public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //slow is the previous node of the nth node from the end, which is n step away from the last node;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        //fast run n steps
        while (n > 0) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            n--;
        }
        
        //then run fast and slow together
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        //delete
        slow.next = slow.next.next;
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
		RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		
		r.removeNthFromEnd(head, 2);
	}
}
