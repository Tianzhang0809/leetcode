import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class fRearrangeStringII {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int d = 3;
		String res = nStepsAway(str, d);
		System.out.println(res);
	}

	public static String nStepsAway(String s, int d) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		Map<Character, Integer> hm = sortByComparator(map);

		char[] arr = new char[s.length()];
		// init arr
		for (int i = 0; i < arr.length; i++) {
			arr[i] = '+';
		}
		int i = 0;
		for (char key : hm.keySet()) {
			while (i < s.length() && arr[i] != '+') {
				i++;
			}
			int count = 0;
			while (hm.get(key) > 0) {
				arr[i + count * d] = key;
				count++;
				hm.put(key, hm.get(key) - 1);
			}
		}

		return new String(arr);
	}

	private static Map sortByComparator(Map unsortMap) {
		List list = new LinkedList(unsortMap.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
						.compareTo(((Map.Entry) (o1)).getValue());
			}
		});

		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	public static void print(char[] arr) {
		for (char c : arr) {
			System.out.print(c);
		}
		System.out.println();
	}

}
