public class LatestCommonAncestor {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.right = new TreeNode(4);
		t.left.left = new TreeNode(8);
		t.right.left = new TreeNode(5);

		TreeNode res = commonAncestor(t, t.left.right, t.left.left);
		System.out.println(res.val);
	}

	public static boolean covers(TreeNode root, TreeNode q) {
		if (root == null) {
			return false;
		}

		if (root == q) {
			return true;
		}

		return covers(root.left, q) || covers(root.right, q);
	}

	public static TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (root == p || root == q) {
			return root;
		}

		boolean p_left_size = covers(root.left, p);
		boolean q_left_size = covers(root.left, q);

		if (p_left_size != q_left_size) {
			return root;
		} else {
			TreeNode childSide = q_left_size ? root.left : root.right;
			return helper(childSide, p, q);
		}
	}

	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		}

		return helper(root, p, q);
	}

}
