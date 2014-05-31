public class ClimbStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(3));

	}

	public static int climbStairs(int n) {
		int[] map = new int[n + 1];
		// init map
		for (int i = 0; i < n; i++) {
			map[i] = -1;
		}

		return helper(map, n);
	}

	public static int helper(int[] map, int n) {
		if (n < 0) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		if (map[n] != -1) {
			return map[n];
		} else {
			map[n] = helper(map, n - 1) + helper(map, n - 2);
			return map[n];
		}
	}
}
