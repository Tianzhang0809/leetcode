public class EditDistance {

	public static void main(String[] args) {
		String s1 = "SUNDAY";
		String s2 = "SATURDAY";
		int out = minDistance(s1, s2);
		System.out.println(out);
	}

	public static int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		int[][] dp = new int[n + 1][m + 1];
		// init
		for (int i = 0; i <= n; i++) {
			dp[i][0] = i;
		}

		for (int i = 0; i <= m; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.println(word1.charAt(i - 1) + " "
						+ word2.charAt(j - 1));
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
							Math.min(dp[i - 1][j], dp[i][j - 1]));
				}
				print(dp);
			}
		}
		return dp[n][m];
	}

	public static void print(int[][] dp) {
		for (int[] arr : dp) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println("-----------");
	}

}
