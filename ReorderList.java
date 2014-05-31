public class ReorderList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		// ListNode n5 = new ListNode(3);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;

		reorderList(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}

	}

	public static ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode mid = findMiddle(head);
		ListNode head2 = reverse(mid.next);
		mid.next = null;

		merge(head, head2);
	}

	public static void merge(ListNode head1, ListNode head2) {
		int index = 0;
		ListNode dummy = new ListNode(0);

		while (head1 != null && head2 != null) {
			if (index % 2 == 0) {
				dummy.next = head1;
				head1 = head1.next;
			} else {
				dummy.next = head2;
				head2 = head2.next;
			}

			dummy = dummy.next;
			index++;
		}

		if (head1 != null) {
			dummy.next = head1;
		} else if (head2 != null) {
			dummy.next = head2;
		}
	}

}
