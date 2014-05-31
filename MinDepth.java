public class MinDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		// root.right = new TreeNode(2);
		System.out.println(minDepth(root));
	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return getMin(root);
	}

	public static int getMin(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		return Math.min(getMin(root.left), getMin(root.right)) + 1;
	}

}
