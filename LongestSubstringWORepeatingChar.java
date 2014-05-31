import java.util.HashSet;

public class LongestSubstringWORepeatingChar {
	public static void main(String[] args) {
		String s = "abcabcd";
		int n = lengthOfLongestSubstring(s);
		System.out.println(n);
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashSet<Character> set = new HashSet<Character>();
		int maxLen = 0;
		int leftBound = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) { // contains the character
				while (leftBound < i && s.charAt(i) != s.charAt(leftBound)) { // removing
																				// until
																				// reaching
																				// that
																				// character
					set.remove(s.charAt(leftBound));
					leftBound++;
				}
				leftBound++; // cross over the character
			} else {
				set.add(c);
				maxLen = Math.max(maxLen, i - leftBound + 1);
			}
		}
		return maxLen;
	}
}
