package educative.fastAndSlowPointers;

import com.bk.utils.ListNode;

public class LinkedListCycleLength {

	public static int findCycleLength(ListNode head) {
		int length = 0;
		ListNode fast = head;
		ListNode slow = head;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if(fast == slow){
				break;
			}
		}
		ListNode counter = slow;
		do {
			counter = counter.next;
			length++;
		} while (counter != slow);
		return length;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);
	    head.next.next.next.next.next = new ListNode(6);
	    head.next.next.next.next.next.next = head.next.next;
	    System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

	    head.next.next.next.next.next.next = head.next.next.next;
	    System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
	}

}

