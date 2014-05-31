public class DecodeWays {
	public static void main(String[] args) {
		String s = "12";
		int n = numDecodings(s);
		System.out.println(n);
	}

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		if (s.charAt(0) == '0') {
			return 0;
		}

		int[] num = new int[s.length() + 1];
		num[0] = 1;
		num[1] = 1;

		int tmp;

		for (int i = 2; i <= s.length(); i++) {
			// check if current character is 0
			tmp = s.charAt(i - 1) - '0';
			if (tmp != 0) {
				num[i] = num[i - 1];
			}

			// check if current character and previous char can form a new code
			if (s.charAt(i - 2) != '0') {
				tmp = Integer.parseInt(s.substring(i - 2, i));
				if (tmp <= 26 && tmp > 0) {
					num[i] += num[i - 2];
				}
			}
		}
		return num[s.length()];

	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
