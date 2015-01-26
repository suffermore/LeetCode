package linkedlist;

import java.util.HashMap;

public class CopyListWithRandomPointer {
	
	//hashmap version
	public RandomListNode copyRandomListI(RandomListNode head) {
		if (head == null) {
			return head;
		}
		
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newNode, preNode;
		
		RandomListNode dummy = new RandomListNode(0);
		preNode = dummy;
		
		while(head != null) {
			if (map.containsKey(head)) {
				newNode = map.get(head);
			} else {
				newNode = new RandomListNode(head.label);
				map.put(head, newNode);
			}
			
			//implement next pointer of the new list
			preNode.next = newNode;

			//implement random pointer of the new list
			if (head.random != null) {
				if (map.containsKey(head.random)) {
					newNode.random = map.get(head.random);
				} else {
					newNode.random = new RandomListNode(head.random.label);
					map.put(head.random, newNode.random);
				}
			}
			
			preNode = newNode;
			head = head.next;
		}
		
		return dummy.next;
	}
	
	//no Hashmap version - tricky method
	public RandomListNode copyRandomListII(RandomListNode head) {
		if (head == null) {
			return head;
		}
		
		copyNext(head);
		copyRandom(head);
		return splitList(head);
	}
	
	private void copyNext(RandomListNode head) {
		RandomListNode newNode;
		while (head != null) {
			newNode = new RandomListNode(head.label);
			newNode.next = head.next;
			head.next = newNode;
			
			//notice how head push forward, two steps each time
			head = head.next.next;
		}
	}
	
	private void copyRandom(RandomListNode head) {
		while(head != null) {
			if (head.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}
	}
	

	private RandomListNode splitList(RandomListNode head) {
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode node = dummy;
		
		//here we do not only create the new lists, but recreate the old one.
		while (head != null) {
			node.next = head.next;
			head.next = head.next.next;
			
			node = node.next;
			head = head.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		CopyListWithRandomPointer c = new CopyListWithRandomPointer();
		RandomListNode head = new RandomListNode(-1);
		c.copyRandomListII(head);
	}
}
