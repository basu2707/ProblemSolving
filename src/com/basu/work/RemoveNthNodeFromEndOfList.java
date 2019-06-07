package com.basu.work;

/**
 * given linked list 1->2->3->4->5 and n = 2, the result is 1->2->3->5
 * @author sivakumar
 *
 */
public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		ListNode head = removeNthFromEnd(n1, 3);
		System.out.println("head: "+head.val );
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		for (int i=0;i<n;i++) {
			fast = fast.next;
			System.out.println(fast.val + " i: " + i);
		}
		
		if (fast.next == null) {
			head = head.next;
			return head;
		}
		
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
			System.out.println("fast: "+ fast.val + " slow: " +slow.val);
		}
		slow.next = slow.next.next;
		
		return slow;
	}

}
