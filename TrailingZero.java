public class TrailingZero {

	public static void main(String[] args) {
		int n = 101;
		int out = countfactzero(n);
		System.out.println(out);

	}

	public static int factorOf5(int n) {
		int count = 0;
		while (n % 5 == 0) {
			count++;
			n /= 5;
		}
		return count;
	}

	public static int countfactzero(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {
			count += factorOf5(i);
		}

		return count;
	}

	// the number of times 5 is a factor
	public static long trailingZeros(long n) {
		int count = 0;
		if (n < 0) {
			return -1;
		}
		if (n == 5) {
			return 1;
		}

		for (int i = 5; i <= n; i *= 5) {
			count += n / i;
		}
		return count;
	}

	// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	//
	// for (int i = 1; i <= n; i++) {
	// addPrimeFactor(i, map);
	// }
	//
	// System.out.println(map);
	// int count = 0;
	// if (!map.containsKey(2) || !map.containsKey(5)) {
	// return 0;
	// }
	//
	// while (map.get(2) > 0 && map.get(5) > 0) {
	// map.put(2, map.get(2) - 1);
	// map.put(5, map.get(5) - 1);
	// count++;
	// }
	// return count;
	// }
	//
	// public static void addPrimeFactor(long n, HashMap<Integer, Integer> map)
	// {
	// if (n < 2) {
	// return;
	// }
	//
	// for (int i = 2; i <= n; i++) {
	// if (n % i == 0 && isPrime(i)) {
	// if (map.containsKey(i)) {
	// map.put(i, map.get(i) + 1);
	// } else {
	// map.put(i, 1);
	// }
	// }
	// }
	// }
	//
	// public static boolean isPrime(int n) {
	// if (n < 2) {
	// return false;
	// }
	// if (n == 2) {
	// return true;
	// }
	// if (n % 2 == 0) {
	// return false;
	// }
	//
	// for (int i = 2; i <= (int) Math.sqrt(n); i++) {
	// if (n % i == 0) {
	// return false;
	// }
	// }
	// return true;
	// }
}
