public class ConvertSortedListToBST {

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

		TreeNode root = sortedListToBST(head);
		System.out.println(root.val);

	}

	public static int getLength(ListNode head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	private static ListNode current;

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		current = head;
		int len = getLength(head);
		return helper(0, len - 1);
	}

	public static TreeNode helper(int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode left = helper(start, mid - 1);
		TreeNode root = new TreeNode(current.val);
		current = current.next;
		TreeNode right = helper(mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}
