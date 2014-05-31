import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		ArrayList<ArrayList<Integer>> res = combinationSum2(candidates, 8);
		System.out.println(res);
	}

	public static ArrayList<ArrayList<Integer>> combinationSum2(
			int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}

		Arrays.sort(candidates);
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(res, list, candidates, target, 0); // use 0 to keep track of
													// position
		return res;
	}

	public static void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, int[] can, int t, int pos) {
		if (t <= 0) {
			if (t == 0) {
				if (!res.contains(list)) {
					res.add(new ArrayList<Integer>(list));
				}
			}
			return;
		}

		for (int i = pos; i < can.length; i++) {
			list.add(can[i]);
			helper(res, list, can, t - can[i], i + 1);
			list.remove(list.size() - 1);
		}
	}
}
