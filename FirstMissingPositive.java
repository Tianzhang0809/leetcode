public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] A = { 3, 2, 8, 1 };
		int out = firstMissingPositive(A);
		System.out.println(out);
	}

	public static int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int n = A.length;
		int inOutOfRange = n + 2;
		// first run, turn every negetive value into an impossible positive
		// value
		// make every value in A is positive
		for (int i = 0; i < n; i++) {
			if (A[i] <= 0) {
				A[i] = inOutOfRange;
			}
		}
		// second run, make A[] as a hash table,
		// A[i] indicate the presence of i + 1
		// the way is that, if k in [1,n] is in A[], then turn A[k -1] to
		// negetive
		for (int i = 0; i < n; i++) {
			int ai = A[i];
			int absi = Math.abs(ai);
			if (absi <= n) {
				A[absi - 1] = -Math.abs(A[absi - 1]);
			}
			print(A);
		}
		// third run, if A[i] is positive, from step 2, we know that i + 1 is
		// missing.
		for (int i = 0; i < n; i++) {
			if (A[i] > 0) {
				return i + 1;
			}
		}
		return n + 1;
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
