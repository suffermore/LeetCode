package linkedlist;

import java.util.HashSet;

public class IntersectionOfTwoLinkedList {
	
	//Hashset - O(m + n) Time, O(m) or O(n) space
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		HashSet<ListNode> set = new HashSet<ListNode>();
		
		while (headA != null || headB != null) {
		    
		    if (headA != null) {
    			if (set.contains(headA)) {
    				return headA;
    			} else {
    				set.add(headA);
    				headA = headA.next;
    			}
		    }
		    
		    if (headB != null) {
    			if (set.contains(headB)) {
    				return headB;
    			} else {
    				set.add(headB);
    				headB = headB.next;
    			}
		    }
		}
		
		return null;
    }

	//Two Pointer - O(m + n) Time, O(1) Space
	public ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
		ListNode p = headA;
		ListNode q = headB;
		
		while(p != q) {
			if (p != null) {
				p = p.next;
			} else {
				p = headB;
			}
			
			if (q != null) {
				q = q.next;
			} else {
				q = headA;
			}
		}
		return p;
	}
	
	//Reverse - O(m + n) time, O(1) space
	public ListNode getIntersectionNodeIII(ListNode headA, ListNode headB) {
		ListNode newHeadA = reverse(headA);
		ListNode newHeadB = reverse(headB);
		
		ListNode pre = null;
		while (newHeadA != null && newHeadB != null && newHeadA.val == newHeadB.val) {
			pre = newHeadA;
			newHeadA = newHeadA.next;
			newHeadB = newHeadB.next;
		}
		
		return pre;
	}
	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
