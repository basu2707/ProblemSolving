package com.basu.work;

/**
 * 
 * Given: 1 -> 2 -> 9 -> 9 Result: 1 -> 3 -> 0 -> 0
 * 
 * @author sivakumar
 *
 */
public class PlusOneToLinkedList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(9);
		ListNode n4 = new ListNode(9);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		ListNode result = plusOne(n1);
		System.out.println(result.val);
		while (result != null && result.next != null) {
			result = result.next;
			System.out.println(result.val);
		}
	}

	public static ListNode plusOne(ListNode head) {
		ListNode h2 = reverse(head);

		ListNode p = h2;

		while (p != null) {
			if (p.val + 1 <= 9) {
				p.val = p.val + 1;
				break;
			} else {
				p.val = 0;
				if (p.next == null) {
					p.next = new ListNode(1);
					break;
				}
				p = p.next;
			}
		}

		return reverse(h2);
	}

	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p1 = head;
		ListNode p2 = p1.next;
		while (p2 != null) {
			ListNode t = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = t;
		}

		head.next = null;

		return p1;
	}
}
