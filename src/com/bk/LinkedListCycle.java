package com.bk;

import java.util.HashSet;

import com.bk.utils.ListNode;

/**
 * Leetcode - https://leetcode.com/problems/linked-list-cycle/ 
 * 
 Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.




Follow up:

Can you solve it using O(1) (i.e. constant) memory?

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class LinkedListCycle {
	// Faster solution
	// Space complexity O(1)
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		
		ListNode slow = head;
		ListNode fast = head;
		while(slow != fast) {
			if(fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;	
	}
	// Slower solution
	// Extra memory 
	public boolean hasCycle1(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		
		while(head != null) {
			if(set.contains(head)) {
				return true;
			} else {
				set.add(head);
			}
			head = head.next;
		}
		return false;	
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(3);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(-1);
		ListNode four = new ListNode(4);
		ListNode head2 = new ListNode(5);

		ListNode head = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = two;
		
		LinkedListCycle linkedListCycle = new LinkedListCycle();
		System.out.println("Expected true found --> " + linkedListCycle.hasCycle(head));
		System.out.println("Expected false found --> " + linkedListCycle.hasCycle(head2));
	}

}
