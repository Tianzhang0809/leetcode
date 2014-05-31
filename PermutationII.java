import java.util.ArrayList;
import java.util.Arrays;

public class PermutationII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}

		Arrays.sort(num);
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];
		helper(res, list, visited, num);
		return res;
	}

	public void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, boolean[] visited, int[] num) {
		if (list.size() == num.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (visited[i] || i != 0 && num[i] == num[i - 1] && !visited[i - 1]) {
				continue;
			}
			list.add(num[i]);
			visited[i] = true;
			helper(res, list, visited, num);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
}
