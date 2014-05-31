import java.util.HashMap;

public class HigestFreq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "strs", "rgs", "app" };
		String s = getHighestFreq(strs);
		System.out.println(s);
	}

	public static String getHighestFreq(String[] strs) {
		if (strs == null || strs.length == 0) {
			return null;
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// initialize
		for (String s : strs) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		String res = "";
		int max = Integer.MIN_VALUE;

		for (String s : map.keySet()) {
			if (map.get(s) > max) {
				max = map.get(s);
				res = s;
			}
		}
		return res;
	}
}
