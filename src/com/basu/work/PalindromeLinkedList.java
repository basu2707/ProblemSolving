package com.basu.work;

import java.util.Stack;

/**
 * 
Given: 1 -> 2 -> 3 -> 3 -> 2 -> 1
Result: True

Given: 1 -> 2 -> 3 -> 2
Result: False
 * @author sivakumar
 *
 */
public class PalindromeLinkedList {
	static ListNode left;

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

//		System.out.println("isPalindromeReversedList: " + isPalindromeReversedList(n1));
//		System.out.println("isPalindromeBreakAndReverseSecondHalf: " + isPalindromeBreakAndReverseSecondHalf(n1));
//		System.out.println("isPalindromeRecursive: " + isPalindromeRecursive(n1));
		System.out.println("isPalindromeStack: "+isPalindromeStack(n1));

	}

	private static boolean isPalindromeStack(ListNode node) {
		ListNode curr = node;
		ListNode runner = node;
		Stack<Integer> stack = new Stack<Integer>();

		while (runner != null) {
			if (runner.next != null) {
				stack.push(curr.val);
				curr = curr.next;
				runner = runner.next.next;
			} else {
				curr = curr.next;
			}
		}
		
		while (curr != null) {
			if (stack.pop().intValue() != curr.val)  return false;
			curr = curr.next;
		}

		return true;
	}

	public static boolean isPalindromeReversedList(ListNode head) {
		if (head == null)
			return true;

		ListNode p = head;
		ListNode prev = new ListNode(head.val);

		while (p.next != null) {
			ListNode temp = new ListNode(p.next.val);
			temp.next = prev;
			prev = temp;
			p = p.next;
		}

		ListNode p1 = head;
		ListNode p2 = prev;

		while (p1 != null) {
			if (p1.val != p2.val)
				return false;

			p1 = p1.next;
			p2 = p2.next;
		}

		return true;
	}

	public static boolean isPalindromeBreakAndReverseSecondHalf(ListNode head) {

		if (head == null || head.next == null)
			return true;

		// find list center
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode secondHead = slow.next;
		slow.next = null;

		// reverse second part of the list
		ListNode p1 = secondHead;
		ListNode p2 = p1.next;

		while (p1 != null && p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		secondHead.next = null;

		// compare two sublists now
		ListNode p = (p2 == null ? p1 : p2);
		ListNode q = head;
		while (p != null) {
			if (p.val != q.val)
				return false;

			p = p.next;
			q = q.next;

		}

		return true;
	}

	public static boolean isPalindromeRecursive(ListNode head) {
		left = head;

		boolean result = helper(head);
		return result;
	}

	public static boolean helper(ListNode right) {

		// stop recursion
		if (right == null)
			return true;

		// if sub-list is not palindrome, return false
		boolean x = helper(right.next);
		if (!x)
			return false;

		// current left and right
		boolean y = (left.val == right.val);

		// move left to next
		left = left.next;

		return y;
	}

}
