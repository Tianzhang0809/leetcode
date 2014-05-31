public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double out = power(3.89707, 2);
		System.out.println(out);

	}

	/**
	 * Neat recursive way
	 * 
	 * @param e
	 * @param n
	 * @return
	 */
	public static double power(double e, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return e; // base case --> get power of 1
		}

		double v = power(e, n / 2);
		System.out.println(v);
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * e;
		}
	}

	public static double pow(double e, int n) {
		if (n < 0) {
			return 1 / power(e, -n);
		} else {
			return power(e, n);
		}
	}

}
