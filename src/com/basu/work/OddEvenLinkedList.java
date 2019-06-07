package com.basu.work;

/**
 * 
Given: 1 -> 2 -> 3 -> 4 -> 5 -> 6
Result: 1 -> 3 -> 5 -> 2 -> 4 -> 6

Given: 1 -> 3 -> 5 -> 6 -> 4 -> 2
Result: 1 -> 5 -> 4 -> 3 -> 6 -> 2
 * @author sivakumar
 *
 */

public class OddEvenLinkedList {

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

		ListNode r = oddEvenList(n1);
		while (r != null) {
			System.out.println("node values: " + r.val);
			r = r.next;

		}
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;

		ListNode result = head;
		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode connectNode = head.next;

		while (p1 != null && p2 != null) {
			ListNode t = p2.next;
			if (t == null)
				break;

			p1.next = p2.next;
			p1 = p1.next;

			p2.next = p1.next;
			p2 = p2.next;
		}

		p1.next = connectNode;
		return result;
	}
}
