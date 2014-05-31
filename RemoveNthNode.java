public class RemoveNthNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		// ListNode n2 = new ListNode(2);
		// ListNode n3 = new ListNode(3);
		// ListNode n4 = new ListNode(4);
		// ListNode n5 = new ListNode(5);
		// ListNode n6 = new ListNode(6);
		// head.next = n2;
		// n2.next = n3;
		// n3.next = n4;
		// n4.next = n5;
		// n5.next = n6;

		ListNode out = removeNthFromEnd2(head, 1);
		while (out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode slow = dummy;
		// fast first run n steps ahead
		for (int i = 0; i < n; i++) {
			if (head == null) {
				return null; // if null return null
			}
			head = head.next;
		}
		System.out.println(head.val);

		while (head != null) { // use fast.next
			head = head.next;
			slow = slow.next;
			// since slow is from dummy and head is from head
		} // slow will be one step ahead of 2b deleted node
		System.out.println(slow.val);

		if (slow.next != null) {
			slow.next = slow.next.next; // delete the node
		}
		return head;
	}

	/**
	 * 
	 */
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0); // consider: {1}, 1
		dummy.next = head;
		head = dummy;
		ListNode tail = head;

		for (int i = 0; i <= n; i++) {
			head = head.next;
		}

		while (head != null) {
			head = head.next;
			tail = tail.next;
		}

		tail.next = tail.next.next; // remove
		return dummy.next;
	}
}
