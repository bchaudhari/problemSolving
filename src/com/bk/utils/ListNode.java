package com.bk.utils;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode() {}
	public ListNode(int val) 
	{
		this.val = val; 
	}
	public ListNode(int val, ListNode next) 
	{
		this.val = val;
		this.next = next; 
	}

	public static void printLinkedList(ListNode node) {
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}
