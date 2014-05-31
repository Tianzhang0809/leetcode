public class SortList {
	public static void main(String[] args) {
		ListNode head = new ListNode(8);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(7);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(6);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		// ListNode mid = findMiddle(head);
		// while (mid != null) {
		// System.out.print(mid.val + " ");
		// mid = mid.next;
		// }
		// System.out.println();

		ListNode out = sortList(head);
		while (out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}
	}

	public static ListNode findMiddle(ListNode head) {
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				tail.next = head1;
				head1 = head1.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		if (head1 != null) {
			tail.next = head1;
		} else if (head2 != null) {
			tail.next = head2;
		}
		return dummy.next;
	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode mid = findMiddle(head);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		return merge(left, right);
	}

}
