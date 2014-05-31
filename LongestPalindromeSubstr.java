public class LongestPalindromeSubstr {
	public static void main(String[] args) {
		String s = "abcdeedc";
		String out = longestPalindrome(s);
		System.out.println(out);
	}

	public static String expandFromCenter(String s, int start, int end) {
		while (start >= 0 && end < s.length()
				&& s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		String longest = s.substring(0, 1);
		String tmp;
		for (int i = 0; i < s.length() - 1; i++) {
			tmp = expandFromCenter(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			tmp = expandFromCenter(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}
}
