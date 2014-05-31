import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EditDistanceII {
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("dat");
		dict.add("bat");
		dict.add("batt");
		dict.add("beetle");
		ArrayList<String> list = getDis(dict, "bat", 1);
		System.out.println(list);
	}

	public static ArrayList<String> getDis(Set<String> dict, String t, int k) {
		ArrayList<String> res = new ArrayList<String>();
		int tlen = t.length();
		for (String str : dict) {
			if (str.length() > tlen + 1 & str.length() < tlen - 1) {
				continue;
			}
			int dis = editDistance(t, str);
			if (dis <= k) {
				res.add(str);
			}
		}
		return res;
	}

	public static int editDistance(String s, String t) {
		int[][] path = new int[s.length() + 1][t.length() + 1];
		// init
		for (int i = 0; i <= s.length(); i++) {
			path[i][0] = i;
		}
		for (int i = 0; i <= t.length(); i++) {
			path[0][i] = i;
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					path[i][j] = path[i - 1][j - 1];
				} else {
					path[i][j] = 1 + Math.min(
							Math.min(path[i - 1][j], path[i][j - 1]),
							path[i - 1][j - 1]);
				}
			}
		}
		return path[s.length()][t.length()];
	}
}
