import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder_II {
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
		System.out.println(count);
	}

	private static int count = 0;

	public static ArrayList<ArrayList<String>> findLadders(String start,
			String end, HashSet<String> dict) {

		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> path = new ArrayList<String>();
		if (start == null || end == null || start.length() != end.length()) {
			return res;
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		bfs(start, end, dict, map);
		System.out.println(map);
		dfs(end, start, dict, path, res, map);
		return res;
	}

	public static void dfs(String start, String end, HashSet<String> dict,
			ArrayList<String> list, ArrayList<ArrayList<String>> res,
			HashMap<String, Integer> map) {// starting from the end all the way
											// down to the start
		System.out.println("list: " + list);
		if (start.equals(end)) {
			list.add(start);
			Collections.reverse(list);
			res.add(new ArrayList<String>(list));
			return;
		}

		if (!map.containsKey(start)) {
			return;
		}

		list.add(start);
		int nextDepth = map.get(start) - 1;

		for (int i = 0; i < start.length(); i++) {
			char[] arr = start.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				if (arr[i] == c) {
					continue;
				}

				arr[i] = c;
				String newWord = new String(arr);

				if (map.containsKey(newWord) && map.get(newWord) == nextDepth) {
					ArrayList<String> newList = new ArrayList<String>(list);
					dfs(newWord, end, dict, newList, res, map);
				}
			}
		}
	}

	public static void bfs(String start, String end, HashSet<String> dict,
			HashMap<String, Integer> map) {
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		map.put(start, 0);

		while (!q.isEmpty()) {
			String curr = q.poll();
			for (int i = 0; i < curr.length(); i++) {
				char[] arr = curr.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (arr[i] == c) {
						continue;
					}

					arr[i] = c;
					String newWord = new String(arr);
					if (newWord.equals(end) || dict.contains(newWord)) {
						if (!map.containsKey(newWord)) {
							map.put(newWord, map.get(curr) + 1);
							q.add(newWord);
						}
					}
				}
			}
		}
	}
}
