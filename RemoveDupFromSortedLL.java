public class RemoveDupFromSortedLL {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode res = deleteDuplicates(head);

		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode curr = head;

		while (curr != null && curr.next != null) {

			while (curr != null && curr.next != null
					&& curr.val == curr.next.val) {
				curr.next = curr.next.next;
			}

			curr = curr.next;
		}

		return head;
	}
}
