public class InsertionSortLL {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(7);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode res = insertionSortList(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		System.out.println();
	}

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);

		while (head != null) {
			ListNode node = dummy;
			while (node.next != null && node.next.val < head.val) {
				node = node.next;
			}

			ListNode tmp = head.next;
			head.next = node.next;
			node.next = head;
			head = tmp;
		}
		return dummy.next;

	}

}
