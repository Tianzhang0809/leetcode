/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * @author oliviazhang
 * 
 */

public class ReverseLLII {

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

		ListNode res = reverseBetween(head, 2, 4);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}

	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m >= n) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		for (int i = 1; i < m; i++) {
			head = head.next;
		}

		ListNode premNode = head;
		ListNode mNode = head.next;
		ListNode nNode = mNode, postnNode = nNode.next;

		for (int i = m; i < n; i++) {
			ListNode next = postnNode.next;
			postnNode.next = nNode;
			nNode = postnNode;
			postnNode = next;
		}

		mNode.next = postnNode;
		premNode.next = nNode;

		return dummy.next;
	}

}
