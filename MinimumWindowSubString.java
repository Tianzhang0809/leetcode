import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWindowSubString {

	public static void main(String[] args) {
		String s = "this is a test string";
		String out = minWindow(s, "tist");
		System.out.println(out);

	}

	public static String minWindow(String S, String T) {
		if (S == null || S.length() == 0) {
			return S;
		}
		if (T == null || T.length() == 0) {
			return "";
		}

		HashMap<Character, Integer> tCounter = new HashMap<Character, Integer>();
		// put characters in T into tCounter
		for (int i = 0; i < T.length(); i++) {
			if (tCounter.containsKey(T.charAt(i))) {
				tCounter.put(T.charAt(i), tCounter.get(T.charAt(i)) + 1);
			} else {
				tCounter.put(T.charAt(i), 1);
			}
		}

		HashMap<Character, Integer> minWindowCounter = new HashMap<Character, Integer>();
		String minWindow = null;
		int tCount = 0, leftBound = 0;

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (!tCounter.containsKey(c)) {
				continue;
			}

			// gather all necessary characters
			if (!minWindowCounter.containsKey(c)) {
				minWindowCounter.put(c, 1);
			} else {
				minWindowCounter.put(c, minWindowCounter.get(c) + 1);
			}

			if (minWindowCounter.get(c) <= tCounter.get(c)) {
				tCount++;
			}

			if (tCount == T.length()) {
				while (leftBound < S.length()) { // shrink down the leftBound of
													// window
					// only could happen at the leftmost character
					char ch = S.charAt(leftBound);
					if (!tCounter.containsKey(ch)) {
						leftBound++;
						continue;
					}

					if (minWindowCounter.get(ch) > tCounter.get(ch)) {
						minWindowCounter.put(ch, minWindowCounter.get(ch) - 1);
						leftBound++;
						continue;
					}
					break;
				}

				if (minWindow == null || i - leftBound + 1 < minWindow.length()) {
					minWindow = S.substring(leftBound, i + 1);
				}
			}
		}

		return minWindow;
	}

	/**
	 * brute force
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public static String minWindow_brute(String S, String T) {
		if (S == null) {
			return null;
		}
		if (T == null) {
			return S;
		}
		String res = S;

		ArrayList<String> allsub = generateSubstring(S);
		for (String s : allsub) {
			if (s.length() < T.length()) {
				continue;
			}
			int count = 0;
			for (char c : T.toCharArray()) {
				if (s.contains(c + "")) {
					count++;
				}
			}
			if (count == T.length() && s.length() < res.length()) {
				res = s;
			}
		}

		return res;
	}

	public static ArrayList<String> generateSubstring(String s) {
		ArrayList<String> res = new ArrayList<String>();
		for (int length = 1; length <= s.length(); length++) {
			for (int start = 0; start + length <= s.length(); start++) {
				String sub = s.substring(start, start + length);
				res.add(sub);
			}
		}
		return res;
	}

}
