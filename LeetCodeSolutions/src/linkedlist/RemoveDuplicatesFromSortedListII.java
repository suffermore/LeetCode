package linkedlist;

public class RemoveDuplicatesFromSortedListII {
	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
	public ListNode deleteDuplicates(ListNode head) {
		//create dummy node, cause the first node might be deleted
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int value = head.next.val;
                //enumerate one by one: delete once it equals to value;
                while (head.next != null && head.next.val == value) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
