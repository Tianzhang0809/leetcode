public class RotateList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode out = rotateRight(head, 2);
		while (out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}

	}

	public static int getLength(ListNode head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		int length = getLength(head);
		n = n % length; // prevent if n is longer than length

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		ListNode tail = dummy;

		for (int i = 0; i < n; i++) {
			head = head.next;
		}
		System.out.println(head.val);

		while (head.next != null) {
			head = head.next;
			tail = tail.next;
		}
		System.out.println(tail.val);
		head.next = dummy.next;
		dummy.next = tail.next;
		tail.next = null;
		return dummy.next;

	}

}
