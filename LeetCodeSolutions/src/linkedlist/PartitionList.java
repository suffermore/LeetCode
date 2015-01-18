package linkedlist;

public class PartitionList {
	/**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
	public ListNode partition(ListNode head, int x) {
		
		//divide into two part which is less than x and more than x
        ListNode dummyLeft = new ListNode(0);
        ListNode left = dummyLeft;
        ListNode dummyRight = new ListNode(0);
        ListNode right = dummyRight;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        
        //merge left and right
        left.next = dummyRight.next;
        //do not forget to end the list with null
        right.next = null;
        return dummyLeft.next;
    }
}
