public class MultiplyString {

	public static void main(String[] args) {
		String out = multiply("9133", "0");
		System.out.println(out);

	}

	public static String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null
				|| num2.length() == 0) {
			return null;
		}

		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();

		int[] d = new int[num1.length() + num2.length()];

		for (int i = 0; i < num1.length(); i++) {
			int a = num1.charAt(i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int b = num2.charAt(j) - '0';
				d[i + j] += a * b;
			}
		}

		// print(d);

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < d.length; i++) {
			int sum = d[i] + carry;
			sb.append(sum % 10);
			carry = sum / 10;
		}

		sb = sb.reverse();
		while (sb.length() > 0 && sb.charAt(0) == '0') { // trick 1: using while
															// loop
			sb.deleteCharAt(0);
		}

		return (sb.length() == 0) ? "0" : sb.toString(); // trick 2: the length
															// of sb can be zero
	}

	public static void print(int[] d) {
		for (int i : d) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
