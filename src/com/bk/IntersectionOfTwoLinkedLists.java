package com.bk;

import java.util.HashSet;
import java.util.Set;

import com.bk.utils.ListNode;

/**
 * Leetcode - https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class IntersectionOfTwoLinkedLists {
	// Very fast approach even though we are iterating over linked lists twice
	// Constant space complexity
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// Find length of two linked lists
		int lenA = findLinkedListLength(headA);
		int lenB = findLinkedListLength(headB);
		
		// Move head node of longer linked list by the position = difference in length
		if(lenA > lenB) {
			while(lenA != lenB) {
				headA = headA.next;
				lenA--;
			}
		} else if(lenB > lenA) {
			while(lenA != lenB) {
				headB = headB.next;
				lenB--;
			}
		}
		
		// Move head nodes of both linked list by 1 position at a time
		while(headA != null || headB != null) {
			// Check if they are pointing to same node - Yes then return node
			if(headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;			
		}
		
		// If no match found return null
		return null;		
	}
	
	public int findLinkedListLength(ListNode head) {
		int counter = 0;
		while(head != null) {
			counter++;
			head = head.next;
		}
		return counter;
	}
	
	// Slow approach
	// Space complexity O(n)
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<ListNode>();
		// Assuming no cycle in linked list
		while(headA != null) {
			set.add(headA); 
			headA = headA.next;
		}
		
		while(headB != null) {
			if(set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}	
	
	public static void main(String[] args) {
		ListNode one = new ListNode(0);
		ListNode two = new ListNode(9);
		ListNode three = new ListNode(1);
		ListNode four = new ListNode(2);
		ListNode five = new ListNode(4);
		ListNode six = new ListNode(3);

		ListNode head1 = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		ListNode head2 = six;
		six.next = four;

		IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
		ListNode result = intersectionOfTwoLinkedLists.getIntersectionNode(head1, head2);
		System.out.println(result.val);
	}

}
