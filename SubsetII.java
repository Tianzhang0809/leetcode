import java.util.ArrayList;
import java.util.Arrays;

public class SubsetII {
	public static void main(String args[]) {
		int[] num = { 1, 2, 2 };
		ArrayList<ArrayList<Integer>> res = subsetsWithDup(num);
		System.out.println(res);
	}

	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		boolean[] visited = new boolean[num.length];
		helper(res, list, visited, num, 0);
		return res;
	}

	public static void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, boolean[] visited, int[] num, int pos) {
		res.add(new ArrayList<Integer>(list));

		for (int i = pos; i < num.length; i++) {
			if (visited[i] || i != 0 && num[i - 1] == num[i] && !visited[i - 1]) {
				continue;
			}
			visited[i] = true;
			list.add(num[i]);
			helper(res, list, visited, num, i);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
}
