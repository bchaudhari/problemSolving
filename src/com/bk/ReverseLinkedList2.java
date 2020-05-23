package com.bk;

import com.bk.utils.ListNode;

/**
 * Leetcode - https://leetcode.com/problems/reverse-linked-list-ii/
 * 
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 <= m <= n <= length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ReverseLinkedList2 {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode current = head;
		ListNode nodeBeforeM = null;
		ListNode next = null;
		ListNode prev = null;
		int count = 1;

		if(m > 1) {
			while(count < m-1) {
				current = current.next;
				count++;
			}

			nodeBeforeM = current;
			current = current.next;
			count++;
		}
		ListNode nodeM = current;

		while(count != n+1) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if(nodeBeforeM != null)
			nodeBeforeM.next = prev;
		else 
			head = prev;
		
		nodeM.next = current;
		
		return head;
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode head = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		ReverseLinkedList2 reverse = new ReverseLinkedList2();
		ListNode.printLinkedList(reverse.reverseBetween(head, 2, 4));
	}

}
