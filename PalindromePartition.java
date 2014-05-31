import java.util.ArrayList;

public class PalindromePartition {
	public static void main(String[] args) {
		String s = "aab";
		ArrayList<ArrayList<String>> res = partition(s);
		System.out.println(res);
	}

	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0) {
			return res;
		}
		ArrayList<String> list = new ArrayList<String>();
		helper(res, list, s, 0);
		return res;
	}

	public static void helper(ArrayList<ArrayList<String>> res,
			ArrayList<String> list, String s, int start) {
		if (start == s.length()) {
			res.add(new ArrayList<String>(list));
			return;
		}

		for (int i = start + 1; i <= s.length(); i++) {
			String sub = s.substring(start, i);
			if (!isPalindrome(sub)) {
				continue;
			}
			list.add(sub);
			helper(res, list, s, i);
			list.remove(list.size() - 1);
		}
	}

	public static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
