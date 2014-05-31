import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ThreeSum {
	public static void main(String[] args) {
		int[] S = { -1, 0, 1, 2, -1, 4 };
		ArrayList<ArrayList<Integer>> res = threeSum(S);
		System.out.println(res);
		ArrayList<ArrayList<Integer>> res1 = threeSum2(S);
		System.out.println(res1);

	}

	/**
	 * ThreeSum using hashmap
	 * 
	 */

	public static ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}

		Arrays.sort(num);
		HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
		for (int i = 0; i < num.length; i++) {
			map.clear();
			for (int j = i + 1; j < num.length; j++) {
				if (map.containsKey(num[j])) {
					int[] pair = map.get(num[j]);
					ArrayList<Integer> level = new ArrayList<Integer>();
					level.add(pair[0]);
					level.add(pair[1]);
					level.add(num[j]);

					if (!res.contains(level)) {
						res.add(level);
					}
				} else {
					map.put(-num[i] - num[j], new int[] { num[i], num[j] });
				}
			}
		}
		return res;

	}

	/**
	 * Three sum not using hashmap
	 * 
	 * @param num
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 1; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (sum == 0) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[left]);
					list.add(num[right]);
					res.add(list);
					left++;
					right--;
					while (left < right && num[left - 1] == num[left]) {
						left++;
					}
					while (left < right && num[right + 1] == num[right]) {
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
}
