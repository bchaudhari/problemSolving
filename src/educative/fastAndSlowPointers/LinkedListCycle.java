package educative.fastAndSlowPointers;

import com.bk.utils.ListNode;

/**
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 * 
 * @author bk
 */
public class LinkedListCycle {
	
	public static boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
	
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);
	    head.next.next.next.next.next = new ListNode(6);
	    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

	    head.next.next.next.next.next.next = head.next.next;
	    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

	    head.next.next.next.next.next.next = head.next.next.next;
	    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
	}

}
