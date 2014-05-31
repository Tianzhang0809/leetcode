import java.util.ArrayList;

public class Combination {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = combine(4, 2);
		System.out.println(res);
	}

	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (n < 1 || k <= 0) {
			return res;
		}
		int[] arr = new int[n];
		// init
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(res, list, arr, k, 0);
		return res;
	}

	public static void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, int[] arr, int k, int pos) {
		if (list.size() == k) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = pos; i < arr.length; i++) {
			list.add(arr[i]);
			helper(res, list, arr, k, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
