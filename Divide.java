public class Divide {
	public static void main(String[] args) {
		int out = divide(19, 6);
	}

	public static int divide(int dividend, int divisor) {
		// step 0: check sign
		boolean neg = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));

		long a = Math.abs((long) dividend); // step 1: make it long
		long b = Math.abs((long) divisor);
		int ans = 0;

		while (a >= b) { // step 3: TWO while loops to check bit

			int shift = 0;

			while ((b << shift) <= a) {
				shift++;
			}

			ans += 1 << (shift - 1);
			a -= (b << (shift - 1));
		}

		return neg ? -ans : ans;
	}
}
