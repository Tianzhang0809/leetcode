public class PathSumToSpecificNumber {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(1);

		findSum(root, 7);

	}

	public static void findSum(TreeNode root, int sum) {
		int depth = getDepth(root);
		int[] path = new int[depth];
		helper(root, sum, path, 0);
	}

	public static void helper(TreeNode root, int sum, int[] path, int level) {
		if (root == null) {
			return;
		}

		path[level] = root.val;
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t += path[i];
			if (t == sum) {
				print(path, i, level);
			}
		}

		helper(root.left, sum, path, level + 1);
		helper(root.right, sum, path, level + 1);
	}

	public static void print(int[] arr, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(getDepth(root.left), getDepth(root.right));
	}

}
