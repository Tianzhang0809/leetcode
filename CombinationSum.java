import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = { 1, 2 };
		ArrayList<ArrayList<Integer>> res = combinationSum(candidates, 2);
		System.out.println(res);
	}

	public static ArrayList<ArrayList<Integer>> combinationSum(
			int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(res, list, candidates, target, 0);
		return res;
	}

	public static void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, int[] can, int t, int pos) {
		if (t <= 0) {
			if (t == 0) {
				res.add(new ArrayList<Integer>(list));
			}
			return;
		}

		for (int i = pos; i < can.length; i++) {
			list.add(can[i]);
			helper(res, list, can, t - can[i], i);
			list.remove(list.size() - 1);

		}
	}

}
