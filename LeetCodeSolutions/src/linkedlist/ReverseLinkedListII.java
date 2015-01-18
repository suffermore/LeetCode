package linkedlist;

public class ReverseLinkedListII {
	/**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        //get the previous node of the mth node
        for (int i = 0; i < m - 1; i++) {
            head = head.next;
        }
        ListNode preNode = head;
        head = head.next;
        ListNode mNode = head;
        ListNode prev = mNode;
        head = head.next;
        for (int i = m + 1; i <= n; i++) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        ListNode nNode = prev;
        preNode.next = nNode;
        ListNode endNode = head;
        mNode.next = endNode;
        return dummy.next;
    }
}
