import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args) {
		String s = "ILoveApple";
		Set<String> dict = new HashSet<String>();
		dict.add("I");
		dict.add("Love");
		dict.add("Apple");

		boolean out = wordBreak3(s, dict);
		System.out.println(out);
	}

	/**
	 * DP method
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return false;
		}

		boolean[] t = new boolean[s.length() + 1];
		t[0] = true;

		for (int start = 0; start < s.length(); start++) {
			if (t[start] != true) {
				continue;
			}

			for (String str : dict) {
				int len = str.length();
				int end = start + len;
				if (end > s.length()) {
					continue;
				}

				if (t[end] == true) {
					continue;
				}

				String sub = s.substring(start, end);
				if (str.equals(sub)) {
					t[end] = true;
				}
			}
		}
		return t[s.length()];
	}

	/**
	 * recursive way
	 */

	public static boolean wordBreak_recursion(Set<String> dict, String s) {
		// check null
		if (dict == null || dict.size() == 0 || s == null) {
			return false;
		}

		if (s.length() == 0) {
			return true;
		}

		for (int i = 1; i <= s.length(); i++) {
			String sub = s.substring(0, i);
			if (dict.contains(sub) && wordBreak_recursion(dict, s.substring(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Naive approach Time: O(2^n)
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static boolean wordBreak_naive(String s, Set<String> dict) {
		return helper(s, dict, 0);
	}

	public static boolean helper(String s, Set<String> dict, int start) {
		if (start == s.length()) {
			return true;
		}

		for (String str : dict) {
			int len = str.length();
			int end = start + len;

			if (end > s.length()) {
				continue;
			}

			if (s.substring(start, end).equals(str)) {
				if (helper(s, dict, end)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Time limit exceed
	 * 
	 * O(2^n)
	 */

	public static int findLong(Set<String> dict) {
		int max = 0;
		for (String ss : dict) {
			int len = ss.length();
			if (len > max) {
				max = len;
			}
		}
		return max;
	}

	public static boolean wordBreak3(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return false;
		}

		boolean[] can = new boolean[s.length() + 1];
		can[0] = true;

		helper(s, dict, can);
		return can[s.length()];
	}

	public static void helper(String s, Set<String> dict, boolean[] can) {
		int longest = findLong(dict);
		for (int end = 1; end <= s.length(); end++) {
			for (int len = 1; len <= end && len <= longest; len++) {
				if (!can[end - len]) {
					continue;
				}
				String sub = s.substring(end - len, end);
				if (dict.contains(sub)) {
					can[end] = true;
					wordBreak(s.substring(end), dict);
				}
			}
		}
	}

}
