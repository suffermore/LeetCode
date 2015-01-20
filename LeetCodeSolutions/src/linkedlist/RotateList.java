package linkedlist;

public class RotateList {
	
	public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        
        //n might larget than length. mod n by length at first
        int len = getLength(head);
        n = n % len;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode tail = head;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }
        
        if(tail == null) {
        	return head;
        }
        
        while (tail.next != null) {
            head = head.next;
            tail = tail.next;
        }
        
        tail.next = dummy.next;
        dummy.next = head.next;
        head.next = null;
        
        return dummy.next;
    }
    
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		
		RotateList r = new RotateList();
		r.rotateRight(head, 1);
	}
}
