import java.util.ArrayList;
import java.util.HashMap;

public class kThMostFreqWord {
	public static void main(String[] args) {
		ArrayList<String> dict = new ArrayList<String>();
		dict.add("ab");
		dict.add("a");
		dict.add("ab");
		dict.add("a");
		dict.add("a");
		dict.add("ab");
		dict.add("c");
		dict.add("e");
		dict.add("f");

		ArrayList<String> res = kMostFrequent(dict, 2);
		System.out.println(res);

	}

	public static ArrayList<String> kMostFrequent(ArrayList<String> dict, int k) {
		ArrayList<String> res = new ArrayList<String>();
		if (dict == null || dict.size() == 0) {
			return res;
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : dict) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}

		for (String key : map.keySet()) {
			res.add(key);
		}

		ArrayList<String> tmp = new ArrayList<String>();
		for (int i = res.size() - 1; i > k; i--) {
			tmp.add(res.get(i));
		}
		return tmp;
	}
}