import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
	public static void main(String[] args) {
		String[] strs = { "eat", "ate", "tea", "eta" };

		ArrayList<String> test = anagrams(strs);
		System.out.println(test);

	}

	public static ArrayList<String> anagrams(String[] strs) {
		HashMap<String, ArrayList<String>> anaHashMap = new HashMap<String, ArrayList<String>>();
		// Start typing your Java solution below
		// DO NOT write main() function
		for (String string : strs) {
			String charBitMap = getCharBitMap(string);

			if (anaHashMap.containsKey(charBitMap)) {
				anaHashMap.get(charBitMap).add(string);
			} else {
				ArrayList<String> newArrayList = new ArrayList<String>();
				newArrayList.add(string);
				anaHashMap.put(charBitMap, newArrayList);
			}
		}

		ArrayList<String> resultList = new ArrayList<String>();
		for (ArrayList<String> strList : anaHashMap.values()) {
			if (strList.size() > 1) {
				resultList.addAll(strList);
			}
		}
		return resultList;
	}

	private static String getCharBitMap(String str) {
		char[] char_array = str.toCharArray();
		int[] char_cnt = new int[26];
		for (char c : char_array) {
			char_cnt[c - 'a'] += 1;
		}

		return Arrays.toString(char_cnt);
	}
}
