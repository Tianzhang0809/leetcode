/**
 * two cases:
 * 
 * 1. if the next character of p is NOT '*', then it must match the current
 * character of s. Continue pattern matching with the next character of both s
 * and p
 * 
 * 2. if the next character of p is "*", then we do brute force exhaustive
 * matching of 0, 1 or more repeats of current character of p
 * 
 * @author oliviazhang
 * 
 */

public class RegularExpression {
	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c*a*b"));
	}

	/**
	 * No. 2
	 */

	public static boolean isMatch2(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1
					|| (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
				return false;
			} else {
				return isMatch2(s.substring(1), p.substring(1));
			}
		} else {
			int len = s.length();
			int i = -1;

			while (i < len
					&& (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s
							.charAt(i))) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}

	/**
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		if (s.length() == 0) {
			return checkEmpty(p);
		}

		if (p.length() == 0) {
			return s.length() == 0;
		}

		char c1 = s.charAt(0);
		char d1 = p.charAt(0), d2 = '0';

		if (p.length() > 1) {
			d2 = p.charAt(1); // change d2
		}

		if (d2 == '*') {
			if (compare(c1, d1)) {
				System.out.println(s + " " + p);
				// or * represents zero preceding character current character
				// not consume * || consume *
				return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
			} else {
				// consume *
				return isMatch(s, p.substring(2));
			}
		} else {
			if (compare(c1, d1)) {
				// continue to compare
				return isMatch(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		}
	}

	public static boolean compare(char c1, char d1) {
		return d1 == '.' || c1 == d1;
	}

	public static boolean checkEmpty(String p) {
		if (p.length() % 2 != 0) {
			return false;
		}

		for (int i = 1; i < p.length(); i += 2) {
			if (p.charAt(i) != '*') {
				return false;
			}
		}
		return true;
	}
}
