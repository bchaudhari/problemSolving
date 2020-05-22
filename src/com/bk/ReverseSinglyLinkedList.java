package com.bk;

import com.bk.utils.ListNode;

/**
 * Leetcode - https://leetcode.com/problems/reverse-linked-list/
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ReverseSinglyLinkedList {

	public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
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
		
		ReverseSinglyLinkedList reverse = new ReverseSinglyLinkedList();
		ListNode newHead = reverse.reverseList(head);
		
		ListNode.printLinkedList(newHead);

	}

}
