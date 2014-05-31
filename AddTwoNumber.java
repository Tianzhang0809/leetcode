public class AddTwoNumber {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		// l1.next = new ListNode(4);
		// // l1.next.next = new ListNode(2);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		// l2.next.next = new ListNode(4);

		ListNode out = addTwoNumbers(l1, l2);
		while (out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;

		while (l1 != null && l2 != null) {
			int curr = l1.val + l2.val;
			System.out.println(l1.val + " " + l2.val + " " + curr);
			tail.next = new ListNode((curr + carry) % 10);
			carry = (curr + carry > 9) ? 1 : 0;
			tail = tail.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		ListNode re = (l1 != null) ? l1 : l2;
		while (re != null) {
			int curr = re.val;
			tail.next = new ListNode((curr + carry) % 10);
			carry = (curr + carry > 9) ? 1 : 0;
			tail = tail.next;
			re = re.next;
		}
		if (carry != 0) {
			tail.next = new ListNode(1);
		}

		return dummy.next;
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}
		return prev;
	}
}
