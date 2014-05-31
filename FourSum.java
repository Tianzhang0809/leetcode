import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	public static void main(String[] args) {
		int[] num = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		ArrayList<ArrayList<Integer>> res = fourSum(num, target);
		System.out.println(res);
	}

	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < num.length - 2; j++) {
				if (j != i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum == target) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
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
					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
			}

		}
		return res;
	}
}
