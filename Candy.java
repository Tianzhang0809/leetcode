import java.util.Arrays;

public class Candy {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 4, 5, 2 };
		int res = candy(arr);
		System.out.println(res);

	}

	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int[] dp = new int[ratings.length];
		Arrays.fill(dp, 1);

		// from left to right
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			}
		}

		// from right to left
		for (int i = ratings.length - 1; i >= 1; i--) {
			if (ratings[i - 1] > ratings[i] && dp[i - 1] <= dp[i]) {
				dp[i - 1] = dp[i] + 1;
			}
		}

		int sum = 0;
		for (int i = 0; i < dp.length; i++) {
			sum += dp[i];
		}
		return sum;
	}
}
