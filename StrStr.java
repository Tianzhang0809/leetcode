public class StrStr {
	public static void main(String[] args) {
		String haystack = "abcdefg";
		String needle = "cde";
		String out = strStr(haystack, needle);
		System.out.println(out);
	}

	public static String strStr(String haystack, String needle) {
		if (haystack == null || needle == null
				|| haystack.length() < needle.length()) {
			return null;
		}

		int len = needle.length();
		for (int i = 0; i + len <= haystack.length(); i++) {
			String sub = haystack.substring(i, i + len);
			if (sub.equals(needle)) {
				return haystack.substring(i);
			}
		}
		return null;
	}
}
