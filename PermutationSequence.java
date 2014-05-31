import java.util.ArrayList;
import java.util.Arrays;

public class PermutationSequence {
	public static void main(String[] args) {
		String out = getPermutation_my(3, 5);
		System.out.println(out);
	}

	public static String getPermutation2(int n, int k) {
		boolean[] output = new boolean[n];
		StringBuilder buf = new StringBuilder("");

		int[] res = new int[n];
		res[0] = 1;

		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * i;
		}

		// print(res);

		for (int i = n - 1; i >= 0; i--) {
			int s = 1;

			while (k > res[i]) {
				s++;
				k = k - res[i];
			}
			System.out.println(k);

			for (int j = 0; j < n; j++) {
				if (j + 1 <= s && output[j]) {
					s++;
				}
			}

			output[s - 1] = true;
			buf.append(Integer.toString(s));
		}

		return buf.toString();
	}

	/**
	 * Nine chapter
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static String getPermutation(int n, int k) {
		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}

		// change k to be index
		k = k - 1;

		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i; // get 1 * 2 * 3
		}

		String result = "";

		// find sequence
		for (int i = 0; i < n; i++) {
			mod /= (n - i);
			// find the right number(curIndex) of
			int curIndex = k / mod;
			// update k
			k = k % mod;

			// get number according to curIndex
			result += numberList.get(curIndex);
			// remove from list
			numberList.remove(curIndex);
		}

		return result.toString();
	}

	/**
	 * my way to solve this problem using old approach to get permutation and
	 * select the specific one we are interested in
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static String getPermutation_my(int n, int k) {
		if (n <= 0) {
			return null;
		}
		int[] num = new int[n];
		// initialize
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}
		ArrayList<ArrayList<Integer>> permutation = permute(num);
		System.out.println(permutation);
		if (k > permutation.size()) {
			return null;
		}
		ArrayList<Integer> s = permutation.get(k - 1);
		StringBuilder sb = new StringBuilder();
		for (Integer i : s) {
			sb.append(i);
		}
		return sb.toString();
	}

	/**
	 * from permutation question
	 * 
	 * @param num
	 * @return
	 */
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
			helper(num, list, res);
			list.remove(list.size() - 1);
		}
	}

	/**
	 * logi
	 */

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
