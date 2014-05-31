public class InterleavingString {
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		boolean out = isInterleave(s1, s2, s3);
		System.out.println(out);
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null) {
			return false;
		}

		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[][] path = new boolean[s1.length() + 1][s2.length() + 1];
		path[0][0] = true;

		// initialize to see which is the start and last for how long
		for (int i = 1; i <= s1.length(); i++) {
			path[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
		}

		for (int i = 1; i <= s2.length(); i++) {
			path[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
		}

		// find the path to see if it links to the end
		// method: compare the current digit in s1 s2 and next digit of s3
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					path[i][j] = path[i][j] || path[i - 1][j];
				}

				if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) { // equals next
					path[i][j] = path[i][j] || path[i][j - 1];
				}

			}
		}

		return path[s1.length()][s2.length()];
	}

	public static void print(boolean[][] path) {
		for (boolean[] b : path) {
			for (boolean c : b) {
				System.out.print(c ? "T " : "F ");
			}
			System.out.println();
		}
		System.out.println("----------");
	}
}
