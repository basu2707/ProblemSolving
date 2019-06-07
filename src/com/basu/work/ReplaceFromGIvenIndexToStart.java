package com.basu.work;

import java.util.Arrays;

public class ReplaceFromGIvenIndexToStart {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(concatLastIndexToStartOfArray(arr, 2)));
		System.out.println(concatLastCharactersToFirst("TestingIndex", 6));

	}

	/**
	 * 
Given a linked list, remove the n-th node from the end of list and return its head.

Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Runtime: 5 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
Memory Usage: 37.9 MB, less than 41.35% of Java online submissions for Remove Nth Node From End of List.
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		ListNode p1 = head;
		ListNode p2 = head;

		for (int i = 0; i < n; i++) {
			p1 = p1.next;
		}

		if (p1 == null) {
			head = head.next;
			return head;
		}

		while (p1.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}

		p2.next = p2.next.next;
		return head;
	}

	private static int[] concatLastIndexToStartOfArray(int[] arr, int index) {
		if (index >= arr.length) {
			return arr;
		}

		int newindx = 0;
		int[] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (index < arr.length) {
				newArr[i] = arr[index];
				index++;
			} else {
				newArr[i] = arr[newindx];
				newindx++;
			}
		}

		return newArr;
	}

	private static String concatLastCharactersToFirst(String givenStr, int index) {
		if (givenStr.length() < index) {
			return givenStr;
		}

		StringBuilder strBuild = new StringBuilder();
		strBuild.append(givenStr.substring(index, givenStr.length()));
		strBuild.append(givenStr.substring(0, index));

		return strBuild.toString();
	}

}
