import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		String[] L = { "foo", "bar" };
		ArrayList<Integer> res = findSubstring(S, L);
		System.out.println(res);

	}

	public static ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		HashMap<String, Integer> lmap = new HashMap<String, Integer>();
		HashMap<String, Integer> smap = new HashMap<String, Integer>();

		// add elements to lmap
		for (String s : L) {
			if (lmap.containsKey(s)) {
				lmap.put(s, lmap.get(s) + 1);
			} else {
				lmap.put(s, 1);
			}
		}

		int m = L.length;
		int n = L[0].length();

		int i, j;
		for (i = 0; i <= S.length() - m * n; i++) {
			smap.clear();
			for (j = 0; j < m; j++) {
				int k = i + j * n; // the kth character 0 ~ m - 1
				String sub = S.substring(k, k + n);
				if (!lmap.containsKey(sub)) {
					break;
				}
				// put the substring into smap
				if (smap.containsKey(sub)) {
					smap.put(sub, smap.get(sub) + 1);
				} else {
					smap.put(sub, 1);
				}

				if (smap.get(sub) > lmap.get(sub)) {
					break;
				}
			}

			if (j == m) {
				res.add(i);
			}
		}
		return res;
	}

}
