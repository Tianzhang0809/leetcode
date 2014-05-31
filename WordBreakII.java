import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		ArrayList<String> res = wordBreak(s, dict);
		System.out.println(res);

	}

	/**
	 * enlightened by qiu
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static ArrayList<String> wordBreak2(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return res;
		}

		ArrayList<String> list = new ArrayList<String>();
		helper(res, list, s, dict);
		return res;
	}

	public static void helper(ArrayList<String> res, ArrayList<String> list,
			String s, Set<String> dict) {
		if (s.length() == 0) {
			StringBuilder sb = new StringBuilder();
			for (String tmp : list) {
				sb.append(tmp).append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			res.add(sb.toString());
			return;
		}

		for (int len = 1; len <= s.length(); len++) {
			String sub = s.substring(0, len);
			if (dict.contains(sub)) {
				list.add(sub);
				helper(res, list, s.substring(len), dict);
				list.remove(list.size() - 1);
			}
		}
	}

	/**
	 * original
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> res = helper(s, dict, map);
		// System.out.println(map);
		return res;
	}

	public static ArrayList<String> helper(String s, Set<String> dict,
			Map<String, ArrayList<String>> map) {

		if (map.containsKey(s)) {
			return map.get(s);
		}

		ArrayList<String> res = new ArrayList<String>();
		// n is the length of current s
		int n = s.length();
		if (n <= 0) {
			return res;
		}

		for (int len = 1; len <= n; len++) {
			String sub = s.substring(0, len);
			// only continue if sub is in the dict
			if (dict.contains(sub)) {
				System.out.println(sub);
				if (len == n) {
					res.add(sub); // add the last string
				} else {
					// else there are still more strings to be processed
					String sub2 = s.substring(len);
					// process the remianing parts of string
					ArrayList<String> tmp = helper(sub2, dict, map);
					System.out.println("sub : " + sub);
					System.out.println(tmp);
					for (String item : tmp) {
						item = sub + " " + item; // add the string in requested
						// format
						res.add(item);
					}
					System.out.println("res : " + res);
				}
			}
		}
		System.out.println(res);

		// use s as key and res as value
		map.put(s, res);
		System.out.println(map);
		return res;
	}
}
