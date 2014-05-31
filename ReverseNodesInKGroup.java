public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);

		ListNode out = reverseKGroup(l1, 2);
		while (out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int count = 0;
		ListNode pre = dummy;
		ListNode cur = head;

		while (cur != null) {
			count++;
			ListNode next = cur.next;
			if (count == k) {
				pre = reverse(pre, next);
				count = 0;
			}
			cur = next;
		}
		return dummy.next;
	}

	public static ListNode reverse(ListNode pre, ListNode end) {

		if (pre == null || pre.next == null) {
			return pre;
		}
		ListNode last = pre.next;
		ListNode cur = last.next;

		while (cur != end) {
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		last.next = end;
		return last;
	}

	/**
	 * 
	 */

	public static void print(ListNode l) {
		while (l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}
		System.out.println();
	}
}
