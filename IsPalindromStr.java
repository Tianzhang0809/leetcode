public class IsPalindromStr {

	public static void main(String[] args) {
		String s1 = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s1));
		String s2 = "1a2";
		System.out.println(isPalindrome(s2));
	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		s = s.toLowerCase();
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			while (start < end && !Character.isAlphabetic(s.charAt(start))
					&& !Character.isDigit(s.charAt(start))) {
				start++;
			}
			while (start < end && !Character.isAlphabetic(s.charAt(end))
					&& !Character.isDigit(s.charAt(end))) {
				end--;
			}

			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}

			start++;
			end--;

		}

		return true;
	}
}
