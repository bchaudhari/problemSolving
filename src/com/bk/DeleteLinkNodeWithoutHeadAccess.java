package com.bk;

import com.bk.utils.ListNode;

/***
 * Leetcode - https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:
Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class DeleteLinkNodeWithoutHeadAccess {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(4);
		ListNode two = new ListNode(5);
		ListNode tree = new ListNode(1);
		ListNode four = new ListNode(9);
		
		one.next = two;
		two.next = tree;
		tree.next = four;
		four.next = null;
		
		DeleteLinkNodeWithoutHeadAccess deleteLinkNodeWithoutHeadAccess = new DeleteLinkNodeWithoutHeadAccess();
		deleteLinkNodeWithoutHeadAccess.deleteNode(two);
		ListNode.printLinkedList(one);
		
	}
}