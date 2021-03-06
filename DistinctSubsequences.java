/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * @author oliviazhang - A subsequence of a string is a new string which is
 *         formed from the original string by deleting some (can be none) of the
 *         characters without disturbing the relative positions of the remaining
 *         characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is
 *         not).
 * 
 */

public class DistinctSubsequences {
	public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		int res = numDistinct(S, T);
		System.out.println();
		System.out.println(res);
	}

	public static int numDistinct(String S, String T) {
		int[][] table = new int[S.length() + 1][T.length() + 1];

		for (int i = 0; i < S.length(); i++) {
			table[i][0] = 1;
		}

		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				table[i][j] = table[i - 1][j];

				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					// copy plus last
					table[i][j] = table[i - 1][j] + table[i - 1][j - 1];
				}
			}
			print(table);
		}
		return table[S.length()][T.length()];
	}

	/**
	 * logistics
	 */

	public static void print(int[][] matrix) {
		for (int[] arr : matrix) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println("-----------");
	}
}
