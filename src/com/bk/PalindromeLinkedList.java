package com.bk;

import com.bk.utils.ListNode;

/**
 * Leetcode - https://leetcode.com/problems/palindrome-linked-list/
 * 
 Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

 *
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		
		ListNode fast = head;
		ListNode slow = head;

		// find the mid point
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// reverse second half
		ListNode tail = reverseLinkedList(slow.next);

		while(tail != null) {
			if(head.value != tail.value) {
				return false;
			}
			head = head.next;
			tail = tail.next;
		}
		return true;
	}

	public ListNode reverseLinkedList(ListNode head) {
		ListNode current = head;
		ListNode next = null;
		ListNode previous = null;

		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}


	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(1);
		ListNode five = new ListNode(1);

//		head.next = two;
//		two.next = three;
//		three.next = four;
//		four.next = five;

		PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
		System.out.println(palindromeLinkedList.isPalindrome(head));
	}
}