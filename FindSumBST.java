import java.util.ArrayList;
import java.util.Stack;

public class FindSumBST {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(5);
		t.left = new TreeNode(3);
		t.right = new TreeNode(7);
		t.left.left = new TreeNode(2);
		t.left.right = new TreeNode(4);
		t.right.right = new TreeNode(6);
		t.right.left = new TreeNode(9);

		int[] res = findSum(t, 10);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	/**
	 * O(n)
	 * 
	 * @param root
	 * @param num
	 * @return
	 */
	public static int[] findSum(TreeNode root, int num) {
		if (root == null) {
			return null;
		}

		ArrayList<Integer> list = treeToArray(root);
		int start = 0;
		int end = list.size() - 1;

		while (start < end) {
			int first = list.get(start);
			int second = list.get(end);
			int sum = first + second;

			if (sum == num) {
				int[] res = new int[2];
				res[0] = first;
				res[1] = second;
				return res;
			} else if (sum < num) {
				start++;
			} else {
				end--;
			}
		}

		return null;

	}

	// Turn the tree into arraylist using inorder traversal
	// time & space : O(n)
	public static ArrayList<Integer> treeToArray(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return null;
		}

		TreeNode current = root;
		while (true) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			if (stack.isEmpty()) {
				return res;
			}

			current = stack.pop();
			res.add(current.val);
			current = current.right;
		}
	}

}
