public class RecoverBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(1);
		recoverTree(root);

	}

	private static TreeNode first = null;
	private static TreeNode second = null;
	private static TreeNode lastNode = new TreeNode(Integer.MIN_VALUE);

	public static void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}

		traverse(root);
		swap(first, second);
	}

	public static void swap(TreeNode first, TreeNode second) {
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}

	public static void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		// in order traversal
		traverse(root.left); // go to left bottom
		if (root.val < lastNode.val && first == null) {
			first = lastNode;
		}
		if (root.val < lastNode.val && first != null) {
			second = root;
		}

		lastNode = root;
		traverse(root.right);
	}

}
