public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] str_arr = { "abcdefg", "abewsad", "abe" };
		String sub = longestCommonPrefix(str_arr);
		System.out.println(sub);

	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return null;
		}

		int index = 0;
		while (index < strs[0].length()) {
			char c = strs[0].charAt(index);
			for (int i = 1; i < strs.length; i++) {
				if (index >= strs[i].length() || strs[i].charAt(index) != c) {
					return strs[0].substring(0, index);
				}
			}
			index++;
		}
		return strs[0];
	}

}
