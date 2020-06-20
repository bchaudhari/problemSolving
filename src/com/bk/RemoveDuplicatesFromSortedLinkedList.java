package com.bk;

import com.bk.utils.ListNode;

/**
 * Leetcode - https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
 * 
   Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class RemoveDuplicatesFromSortedLinkedList {
	
	// Runtime: 0 ms
	// Faster than 100% of leetcode submissions
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = head.next;
		while(next != null) {
			if(cur.val == next.val) {
				next = next.next;
				cur.next = next;
			}
			else {
				cur = next;
				next = next.next;
			}
		}
		return head;
	}
}
