package linkedlist;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head. next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (head.next == null) {
                break;
            } else {
                ListNode temp = head.next.next;
                pre.next = head.next;
                head.next.next = head;
                head.next = temp;
                
                head = temp;
                pre = pre.next.next;
            }
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		
		SwapNodesInPairs s = new SwapNodesInPairs();
		s.swapPairs(head);
	}
}
