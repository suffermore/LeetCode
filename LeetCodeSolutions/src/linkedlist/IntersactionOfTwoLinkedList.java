package linkedlist;

import java.util.HashSet;

public class IntersactionOfTwoLinkedList {
	
	//Hashset: O(m + n) Time, O(m) or O(n) Space
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
		HashSet<ListNode> set = new HashSet<ListNode>();
        
		while(headA!=null||headB!=null){
            if(headA!=null) {
                if(set.contains(headA)){
                    return headA;
                } else {
                    set.add(headA);
                }
                headA=headA.next;
            }

            if(headB!=null) {
                if(set.contains(headB)) {
                    return headB;
                } else {
                    set.add(headB);
                }
                headB=headB.next;
            }
        }
        return null;
    }
	
	//Two pointer - O(m + n) time, O(1) space
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
	
	
}
