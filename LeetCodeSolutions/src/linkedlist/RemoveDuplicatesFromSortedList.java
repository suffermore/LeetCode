package linkedlist;

public class RemoveDuplicatesFromSortedList {
	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                //do not move node forward now, because next node might be still the same value
            } else {
            	//push forward only when two adjacent node are not equal
            	node = node.next;
            }
        }
        return head;
    }
}
