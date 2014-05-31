import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderII {
	public static void main(String[] args) {
		String s = "hit";
		String e = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		ArrayList<ArrayList<String>> out = findLadders(s, e, dict);
		System.out.println(out);
	}

	public static ArrayList<ArrayList<String>> findLadders(String start,
			String end, HashSet<String> dict) {

		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		HashMap<String, HashSet<String>> visited = new HashMap<String, HashSet<String>>();
		HashMap<String, Integer> level = new HashMap<String, Integer>();

		if (start == null || end == null || start.length() == 0
				|| end.length() == 0 || dict == null || dict.size() == 0) {
			return res;
		}
		int minLen = Integer.MAX_VALUE;

		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		level.put(start, 1);
		HashSet<String> path = new HashSet<String>();
		visited.put(start, path);

		while (!q.isEmpty()) {
			String current = q.poll();
			char[] chars = current.toCharArray();

			for (int i = 0; i < chars.length; i++) {
				char old = chars[i];
				// start to replace
				for (char c = 'a'; c <= 'z'; c++) {
					chars[i] = c;
					String nextWord = new String(chars);
					if (dict.contains(nextWord)
							&& (!level.containsKey(nextWord) || level
									.containsKey(nextWord)
									&& level.get(nextWord) > level.get(current))) {
						if (visited.containsKey(nextWord)) {
							visited.get(nextWord).add(current);
						} else {
							path = new HashSet<String>();
							path.add(current);
							visited.put(nextWord, path);
							level.put(nextWord, level.get(current) + 1);
							q.add(nextWord);
						}
					}

					// special case --> reach the end
					if (nextWord.equals(end)) {
						if (level.get(current) < minLen) {
							ArrayList<String> entry = new ArrayList<String>();
							entry.add(end);
							res.addAll(backtrace(current, visited, entry));
							minLen = level.get(current) + 1;
						} else { // not the minimum
							break;
						}
					}
				}

				chars[i] = old;
			}
		}
		return res;

	}

	public static ArrayList<ArrayList<String>> backtrace(String end,
			HashMap<String, HashSet<String>> visited, ArrayList<String> path) {

		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> entry = new ArrayList<String>(path);
		entry.add(0, end); // add before
		if (visited.get(end).size() < 1) {
			res.add(entry);
			return res;
		}

		for (String str : visited.get(end)) {
			res.addAll(backtrace(str, visited, entry));
		}
		return res;
	}
}
