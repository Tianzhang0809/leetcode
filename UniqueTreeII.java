import java.util.ArrayList;

public class UniqueTreeII {

	public static void main(String[] args) {
		ArrayList<TreeNode> res = generateTrees(4);
		System.out.println(res);

	}

	public static ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public static ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null); // add the end null node
			return res;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = generateTrees(start, i - 1); // left
																	// trees
			ArrayList<TreeNode> right = generateTrees(i + 1, end); // right
																	// trees

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;

	}
}
