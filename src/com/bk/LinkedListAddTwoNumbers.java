package com.bk;

import com.bk.utils.ListNode;

/***
 * Leetcode - https://leetcode.com/problems/add-two-numbers/
 * 
 * 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class LinkedListAddTwoNumbers {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode result = new ListNode(0); // dummy node to start with
			ListNode current = result;
			int sum = 0;
			int cf = 0; // carry forward
			while(l1 != null || l2 != null) {
				sum = cf;
				if(l1 != null) {
					sum = sum + l1.val;
					l1 = l1.next;
				} if(l2 != null) {
					sum = sum + l2.val;
					l2 = l2.next;
				}
				
				cf = sum/10;
				current.next = new ListNode(sum % 10);
				current = current.next;	
			}
			if(cf > 0) {
				current.next = new ListNode(cf);
			}
			return result.next; // skip dummy node
		}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(6);
		
		ListNode head1 = n1;
		n1.next = n2;
		n2.next = n3;
		
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(7);
		
		ListNode head2 = n4;
		n4.next = n5;
		n5.next = n6;
		
		LinkedListAddTwoNumbers addTwoNumbers = new LinkedListAddTwoNumbers();
		ListNode result = addTwoNumbers.addTwoNumbers(head1, head2);
		ListNode.printLinkedList(result);

	}

}
