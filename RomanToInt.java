import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static void main(String args[]) throws Exception {
		// IV => 4
		// VII => 6
		System.out.println(romanToInt("MCMLIV"));

	}

	public static int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> m = new HashMap<Character, Integer>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);

		char[] s_arr = s.toCharArray();
		int[] arr = new int[s.length()];
		for (int i = 0; i < s_arr.length; i++) {
			char c = s_arr[i];
			arr[i] = m.get(c);
		}

		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != 0 && arr[i] > arr[i - 1]) {
				res -= 2 * arr[i - 1];
				res += arr[i];
			} else {
				res += arr[i];
			}
		}
		return res;

	}
}
