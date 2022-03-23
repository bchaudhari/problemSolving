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
public class RemoveDuplicatesFromSortedLinkedList2 {
	// Using recursion
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;

		if (head.next != null && head.value == head.next.value) {
			while (head.next != null && head.value == head.next.value) {
				head = head.next;
			}
			return deleteDuplicates(head.next);
		} else {
			head.next = deleteDuplicates(head.next);
		}
		return head;
	}
	public ListNode deleteDuplicates2(ListNode head) {
		//use two pointers, slow - track the node before the dup nodes, 
		// fast - to find the last node of dups.
		ListNode dummy = new ListNode(0), fast = head, slow = dummy;
		slow.next = fast;
		while(fast != null) {
			while (fast.next != null && fast.value == fast.next.value) {
				fast = fast.next;    //while loop to find the last node of the dups.
			}
			if (slow.next != fast) { //duplicates detected.
				slow.next = fast.next; //remove the dups.
				fast = slow.next;     //reposition the fast pointer.
			} else { //no dup, move down both pointer.
				slow = slow.next;
				fast = fast.next;
			}

		}
		return dummy.next;
	} 
	// Runtime: 1
	// Faster than 29.99% of leetcode submissions
	public ListNode deleteDuplicates1(ListNode head) {

		if(head == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = head.next;
		Boolean deleteCur = false;
		while(cur != null) {
			// Remove all duplicates except first one(current)
			if(next != null && cur.value == next.value) {
				next = next.next;
				cur.next = next;
				deleteCur = true;
			}
			// Remove current 
			else if(deleteCur == true) {
				// Move head before deleting current
				if(cur == head) {
					head = next;
				}

				if(prev == null) {
					prev = next;
					cur = next;	
				} else {
					prev.next = cur.next;
					cur = next;
				}
				next = (next == null) ? null: next.next;
				deleteCur = false;
			}
			else {
				prev = cur;
				cur = next;
				next = next == null ? null: next.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(1);
		ListNode three = new ListNode(2);
		head.next = two;
		two.next = three;

		RemoveDuplicatesFromSortedLinkedList2 removeDup = new RemoveDuplicatesFromSortedLinkedList2();
		head = removeDup.deleteDuplicates(head);
		ListNode.printLinkedList(head);
	}
}
