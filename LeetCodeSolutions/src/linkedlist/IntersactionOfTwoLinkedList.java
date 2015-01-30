package linkedlist;

import java.util.HashSet;

public class IntersactionOfTwoLinkedList {
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
}
