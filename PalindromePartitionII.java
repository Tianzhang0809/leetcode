public class PalindromePartitionII {
	public static void main(String[] args) {
		String s = "aab";
		int res = minCut(s);
		System.out.println(res);
	}

	public static int minCut(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		int[] cut = new int[s.length() + 1];
		cut[0] = 0;
		boolean[][] isPalindrome = getPalindrome(s); // where can cut and where
														// cannot

		print(isPalindrome);

		for (int end = 1; end <= s.length(); end++) {
			cut[end] = Integer.MAX_VALUE;
			for (int length = 1; length <= s.length() && length <= end; length++) {
				if (cut[end - length] == Integer.MAX_VALUE) {
					continue; // cannnot cut from here!
				}
				if (isPalindrome[end - length][end - 1]) {
					cut[end] = Math.min(cut[end], cut[end - length] + 1);
				}
			}
		}
		return cut[s.length()] - 1;
	}

	public static boolean[][] getPalindrome(String s) {
		int size = s.length();
		boolean[][] isPalindrome = new boolean[size][size];
		// initialization
		for (int i = 0; i < size; i++) {
			isPalindrome[i][i] = true;
		}
		for (int i = 0; i < size - 1; i++) { // if length == 2 just compare the
												// two characters
			isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
		}

		for (int length = 2; length < s.length(); length++) {
			for (int start = 0; start + length < s.length(); start++) {
				isPalindrome[start][start + length] = (isPalindrome[start + 1][start
						+ length - 1] && s.charAt(start) == s.charAt(start
						+ length)); // compare if previous is palin and the
									// current two characters
			}
		}
		return isPalindrome;
	}

	public static void print(boolean[][] ma) {
		for (boolean[] m : ma) {
			for (boolean a : m) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
