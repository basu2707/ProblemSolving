package com.basu.work;

/**
 * 
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

Runtime: 2 ms, faster than 99.31% of Java online submissions for Reorder List.
Memory Usage: 40.2 MB, less than 30.69% of Java online submissions for Reorder List.
 * @author sivakumar
 *
 */

class ListNode {
	int val;
	ListNode next;
 
	ListNode(int x) {
		val = x;
		next = null;
	}
}
 
public class ReorderLinkedList {
 
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
		
		printList(n1);
 
		reorderList(n1);
 
		printList(n1);
	}
 
	public static void reorderList(ListNode head) {
 
		if (head != null && head.next != null) {
 
			ListNode slow = head;
			ListNode fast = head;
 
			//use a fast and slow pointer to break the link to two parts.
			while (fast != null && fast.next != null && fast.next.next!= null) {
				//why need third/second condition?
				System.out.println("slow: "+slow.val + " fast: " + fast.val);
				slow = slow.next;
				fast = fast.next.next;
				System.out.println("slow: " + slow.val + " fast: " + fast.val);
			}
 
			ListNode second = slow.next;
			System.out.println("second " + second.val);
			slow.next = null;// need to close first part
 
			// now should have two lists: head and fast
 
			// reverse order for second part
			second = reverseOrder(second);
			System.out.println("second after reverse " + second.val + " head: "+ head.val);
			ListNode p1 = head;
			ListNode p2 = second;
			System.out.println("P1:  " + p1.val + " P2: "+ p2.val);
			//merge two lists here
			while (p2 != null) {
				ListNode temp1 = p1.next;
				ListNode temp2 = p2.next;
 
				p1.next = p2;
				p2.next = temp1;		
 
				p1 = temp1;
				p2 = temp2;
			}
		}
	}
 
	public static ListNode reverseOrder(ListNode head) {
 
		if (head == null || head.next == null) {
			return head;
		}
 
		ListNode pre = head;
		ListNode curr = head.next;
		System.out.println("PRE: " + pre.val + " CURR: " + curr.val);
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}

		// set head node's next
		head.next = null;
 
		return pre;
	}
 
	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
		System.out.println();
	}
}
