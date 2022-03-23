package com.bk.utils;

public class ListNode {
	public int value;
	public ListNode next;
	public ListNode() {}
	public ListNode(int val) 
	{
		this.value = val; 
	}
	public ListNode(int val, ListNode next) 
	{
		this.value = val;
		this.next = next; 
	}

	public static void printLinkedList(ListNode node) {
		System.out.print("\n");
		while(node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
}
