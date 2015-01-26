package linkedlist;

public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        
        int carry = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
        	sum = l1.val + l2.val + carry;
            node.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        
        //check whether l1 and l2 are end
        while (l1 != null) {
        	sum = l1.val + carry;
        	node.next = new ListNode(sum % 10);
        	carry = sum / 10;
        	l1 = l1.next;
        	node = node.next;
        }
        while (l2 != null) {
        	sum = l2.val + carry;
        	node.next = new ListNode(sum % 10);
        	carry = sum / 10;
        	l2 = l2.next;
        	node = node.next;
        }
        
        if (carry != 0) {
        	node.next = new ListNode(carry);
        }
        
        return head.next;
    }
	
	public static void main(String[] args) {
		AddTwoNumber a = new AddTwoNumber();
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(1);
		
		a.addTwoNumbers(l1, l2);
	}
}
