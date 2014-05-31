import java.util.ArrayList;

public class PathSumII {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(5);
		t.left = new TreeNode(4);
		t.right = new TreeNode(8);
		t.left.left = new TreeNode(11);
		t.left.left.left = new TreeNode(7);
		t.left.left.right = new TreeNode(2);

		t.right.left = new TreeNode(13);
		t.right.right = new TreeNode(4);
		t.right.right.left = new TreeNode(5);
		t.right.right.right = new TreeNode(1);
		ArrayList<ArrayList<Integer>> res = pathSum(t, 22);
		System.out.println(res);
	}

	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(res, list, root, sum);
		return res;
	}

	public static void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, TreeNode root, int sum) {

		if (root == null) {
			return;
		}

		sum -= root.val;
		if (root.left == null && root.right == null) { // last node
			if (sum == 0) {
				list.add(root.val);
				res.add(new ArrayList<Integer>(list));
				list.remove(list.size() - 1);
			}
			return;
		}

		list.add(root.val);
		helper(res, list, root.left, sum);
		helper(res, list, root.right, sum);
		list.remove(list.size() - 1);

	}
}
