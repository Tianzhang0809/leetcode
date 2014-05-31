public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		copyNext(head);
		copyRandom(head);
		return splitList(head);
	}

	public static void copyNext(RandomListNode head) {
		while (head != null) {
			RandomListNode newnode = new RandomListNode(head.label);
			newnode.next = head.next;
			newnode.random = head.random;
			head.next = newnode;
			head = head.next.next;
		}
	}

	public static void copyRandom(RandomListNode head) {
		while (head != null) {
			if (head.next.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}
	}

	public static RandomListNode splitList(RandomListNode head) {
		RandomListNode newhead = head.next;

		while (head != null) {
			RandomListNode tmp = head.next;
			head.next = head.next.next;
			head = head.next;
			if (tmp.next != null) {
				tmp.next = tmp.next.next;
			}
		}
		return newhead;
	}
}
