import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(7);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;

		ListNode head2 = new ListNode(4);
		ListNode n6 = new ListNode(5);
		head2.next = n6;

		ListNode head3 = new ListNode(5);
		ListNode n7 = new ListNode(6);
		head3.next = n7;

		ArrayList<ListNode> list = new ArrayList<ListNode>();
		list.add(head);
		list.add(head2);
		list.add(head3);

		ListNode res = mergeKLists(list);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}

	}

	private static Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
		public int compare(ListNode left, ListNode right) {
			if (left == null) {
				return 1;
			} else if (right == null) {
				return -1;
			}
			return left.val - right.val;
		}
	};

	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
				ListNodeComparator);
		for (ListNode head : lists) {
			pq.offer(head);
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		while (!pq.isEmpty()) {
			ListNode curr = pq.poll();
			tail.next = curr;
			tail = tail.next;
			if (curr.next != null) {
				pq.offer(curr.next);
			}
		}
		return dummy.next;
	}
}
