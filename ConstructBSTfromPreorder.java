import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBSTfromPreorder {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 1, 7, 40, 50 };
		TreeNode root = constructTree(arr);
		ArrayList<ArrayList<Integer>> res = levelOrder(root);
		System.out.println(res);

	}

	public static TreeNode constructTree(int[] pre) {
		if (pre == null || pre.length == 0) {
			return null;
		}
		Arrays.sort(pre);
		return createBST(pre, 0, pre.length - 1);
	}

	public static TreeNode createBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createBST(arr, start, mid - 1);
		root.right = createBST(arr, mid + 1, end);
		return root;
	}

	//

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) { // traverse every node on this
												// level
				TreeNode current = q.poll();
				list.add(current.val);
				if (current.left != null) {
					q.offer(current.left);
				}
				if (current.right != null) {
					q.offer(current.right);
				}
			}
			res.add(list);
		}
		return res;
	}

}
