import java.util.ArrayList;
import java.util.HashMap;

public class FindSubstring {
	public static void main(String[] args) {
		String s = "abababab";
		String[] L = { "ab", "ab", "ab" };
		ArrayList<Integer> res = findSubstring(s, L);
		System.out.println(res);
	}

	public static ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> found = new HashMap<String, Integer>();

		int count = L.length, len = L[0].length();

		// put all the data and number of occurance into hashmap
		for (int i = 0; i < count; i++) {
			if (!toFind.containsKey(L[i])) {
				toFind.put(L[i], 1);
			} else {
				toFind.put(L[i], toFind.get(L[i]) + 1);
			}
		}

		// traverse all possible starts: from 0 to S.length() - count * len
		for (int start = 0; start <= S.length() - count * len; start++) {
			
			found.clear(); // found is the tmp holdings
			int num;
			for (num = 0; num < count; num++) {
				int k = start + num * len;
				String sub = S.substring(k, k + len);
				if (!toFind.containsKey(sub)) {
					break;
				}
				if (!found.containsKey(sub)) {
					found.put(sub, 1);
				} else {
					found.put(sub, found.get(sub) + 1);
				}
				
				if (found.get(sub) > toFind.get(sub)) {
					break;
				}
			}
			
			if (num == count) {
				res.add(start);
			}
		}
		
		return res;

	}
}
