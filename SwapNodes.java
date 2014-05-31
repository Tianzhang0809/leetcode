public class SwapNodes {
	/**
	 * swap nodes in pair
	 * 
	 * 1->2->3->4 => 2->1->4->3
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode n = swapPairs(head);
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		while (dummy.next != null && dummy.next.next != null) {
			ListNode tmp = dummy.next.next.next;
			dummy.next.next.next = dummy.next;
			dummy.next = dummy.next.next;
			dummy.next.next.next = tmp;
			dummy = dummy.next.next;
		}

		return head.next;

	}

}
