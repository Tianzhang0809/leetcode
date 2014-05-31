public class Sqrt {

	public static void main(String[] args) {
		double res = sqrt2(9);
		System.out.println(res);

	}

	public static int sqrt2(int x) {
		long low = 0;
		long high = x;
		while (Math.abs(high - low) > 0.001) {
			long mid = low + (high - low) / 2;

			if (x < mid * mid) {
				high = mid - 1;

			} else {
				low = mid + 1;

			}
		}

		return Math.round(high);
	}

	public static double sqrt(double x) {
		if (x < 0) {
			return x;
		}

		double mid, last;
		double low = 0, high = x;
		double epsilon = 0.001;

		mid = low + (high - low) / 2;

		do {
			if (mid * mid > x) {
				high = mid;
			} else {
				low = mid;
			}
			last = mid;
			mid = low + (high - low) / 2;
		} while (Math.abs(mid - last) > epsilon);

		return mid;
	}
}
