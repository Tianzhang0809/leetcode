public class SymmetricTree {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(2);
		t.left.right = new TreeNode(3);
		t.right.left = new TreeNode(3);

		boolean res = isSymmetric(t);
		System.out.println(res);
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	public static boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left != null && right == null || left == null && right != null
				|| left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}
}
