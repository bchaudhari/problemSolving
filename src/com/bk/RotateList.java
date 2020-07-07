package com.bk;

import com.bk.utils.ListNode;

/**
 * Leetcode - https://leetcode.com/problems/rotate-list/
 * 
   Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class RotateList {
	
	// Runtime 1 ms
	// Faster than 39.25
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) return head;
		int size = 0;
		ListNode temp = head;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		
		k = k % size;
	
		ListNode slow = head;
		ListNode fast = head;
		
		while(k > 0) {
			fast = fast.next;
			k--;
		}
		
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		fast.next = head;
		head = slow.next;
		slow.next = null;

		return head;
	}
	public static void main(String[] args) {
		RotateList rotateList = new RotateList();
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		ListNode.printLinkedList(rotateList.rotateRight(head, 2));
		
		ListNode head2 = new ListNode(0);
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		head2.next  = a;
		a.next = b;
		
		ListNode.printLinkedList(rotateList.rotateRight(head2, 4));
	}

}
