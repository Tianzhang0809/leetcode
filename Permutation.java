import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> res = permute(num);
		System.out.println(res);
	}

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}
		Arrays.sort(num);
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(num, list, res);
		return res;
	}

	public static void helper(int[] num, ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> res) {
		if (list.size() == num.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (list.contains(num[i])) {
				continue;
			}
			list.add(num[i]);
			System.out.println("b: " + list);
			helper(num, list, res);
			list.remove(list.size() - 1);
			System.out.println("a: " + list);
		}
	}
}
