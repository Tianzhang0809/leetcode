import java.util.HashMap;

public class IntersectLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode n2 = new ListNode(6);
		ListNode n3 = new ListNode(9);
		ListNode n4 = new ListNode(15);
		ListNode n5 = new ListNode(30);

		ListNode head2 = new ListNode(10);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		head2.next = n4;
		boolean res = isIntersect1(head, head2);
		System.out.println(res);
	}

	public static boolean isIntersect1(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return false;
		}

		// find if the last nodes of l1 and l2 are equal
		while (l1.next != null) {
			l1 = l1.next;
		}
		while (l2.next != null) {
			l2 = l2.next;
		}

		return l1 == l2;
	}

	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static boolean isIntersect2(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return false;
		}

		HashMap<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();
		while (l1 != null) {
			map.put(l1, true);
			l1 = l1.next;
		}

		while (l2 != null) {
			if (map.containsKey(l2) && map.get(l2)) {
				return true;
			}

			l2 = l2.next;
		}
		return false;
	}

}
