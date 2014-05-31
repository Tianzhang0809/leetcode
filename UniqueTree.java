public class UniqueTree {

	public static void main(String[] args) {
		System.out.println(numTrees_recursion(4));

	}

	/**
	 * dp way
	 * 
	 * @param n
	 * @return
	 */
	public static int numTrees(int n) {
		int[] dp = new int[n];
		return helper(n, dp);
	}

	public static int helper(int n, int[] num) {
		if (n <= 1) {
			return 1;
		} else if (num[n - 1] != 0) {
			return num[n - 1];
		} else {
			int left, right;
			for (int i = 1; i <= n; i++) {
				left = helper(i - 1, num);
				right = helper(n - i, num);
				num[n - 1] += left * right;
			}
			return num[n - 1];
		}
	}

	public static int numTrees_recursion(int n) {
		if (n <= 1) {
			return 1;
		}

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int left = numTrees_recursion(i - 1);
			int right = numTrees_recursion(n - i);

			sum += left * right;
		}
		return sum;
	}

}
