public class FlattenBTtoLinkedList {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(5);
		t.left.left = new TreeNode(3);
		t.left.right = new TreeNode(4);
		t.right.right = new TreeNode(6);

		flatten(t);
		while (t != null) {
			System.out.println(t.val);
			t = t.right;
		}

	}

	private static TreeNode lastNode = null;

	public static void flatten(TreeNode root) {

		if (root == null) {
			return;
		}

		if (lastNode != null) {
			lastNode.right = root;
			lastNode.left = null;
		}

		lastNode = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}
}
