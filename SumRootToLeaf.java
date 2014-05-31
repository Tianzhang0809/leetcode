public class SumRootToLeaf {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(9);

		int res = sumNumbers(t);
		System.out.println(res);
	}

	public static int sumNumbers(TreeNode root) {
		int prev = 0;
		return dfs(root, prev);
	}

	public static int dfs(TreeNode root, int prev) {
		if (root == null) {
			return 0;
		}
		int sum = root.val + 10 * prev;
		if (root.left == null && root.right == null) {
			return sum;
		}
		return dfs(root.left, sum) + dfs(root.right, sum);
	}

}
