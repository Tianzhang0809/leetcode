import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
	public static void main(String[] args) {
		String s = "hot";
		String e = "dog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hit");
		// dict.add("dot");
		// dict.add("dog");
		dict.add("lot");
		dict.add("log");

		int out = ladderLength(s, e, dict);
		System.out.println(out);
	}

	/**
	 * breadth first search
	 * 
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	public static int ladderLength(String start, String end,
			HashSet<String> dict) {
		if (dict == null || dict.size() == 0) {
			return 0;
		}

		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		dict.remove(start);
		int length = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String current = q.poll();
				for (char c = 'a'; c <= 'z'; c++) {
					for (int j = 0; j < current.length(); j++) {
						if (c == current.charAt(j)) {
							continue;
						}
						String tmp = replace(current, j, c);
						if (tmp.equals(end)) {
							return length + 1;
						}
						if (dict.contains(tmp)) {
							q.offer(tmp);
							dict.remove(tmp);
						}
					}
				}
			}
			length++;
		}
		return 0;
	}

	public static String replace(String arr, int pos, char c) {
		char[] chars = arr.toCharArray();
		chars[pos] = c;
		return new String(chars);
	}
}
