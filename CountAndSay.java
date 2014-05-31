public class CountAndSay {
	public static void main(String[] args) {
		int i = 5;
		String out = countAndSay(i);
		System.out.println(out);
	}

	public static String countAndSay(int n) {
		String str = "1";

		while (--n > 0) {
			char[] arr = str.toCharArray();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < arr.length; i++) {
				int count = 1;
				while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
					count++;
					i++;
				}
				sb.append(count).append(arr[i]);
			}

			str = sb.toString();
		}
		return str;
	}

	public static void print(char[] arr) {
		for (char c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
}
