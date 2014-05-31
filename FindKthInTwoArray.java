public class FindKthInTwoArray {
	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 4 };
		int[] B = { 1, 2, 3, 5 };
		int out = 0;
		for (int i = 1; i <= A.length + B.length; i++) {
			out = findKth(A, B, i, 0, 0);
			System.out.println(out);
		}

	}

	public static int findKth(int[] A, int[] B, int k, int aStart, int bStart) {
		if (aStart >= A.length) {
			return B[bStart + k - 1];
		}
		if (bStart >= B.length) {
			return A[aStart + k - 1];
		}
		if (k == 1) {
			return Math.min(A[aStart], B[bStart]);
		}

		int A_key = (aStart + k / 2 - 1 < A.length) ? A[aStart + k / 2 - 1]
				: Integer.MAX_VALUE;
		int B_key = (bStart + k / 2 - 1 < B.length) ? B[bStart + k / 2 - 1]
				: Integer.MAX_VALUE;

		if (A_key < B_key) {
			return findKth(A, B, k - k / 2, aStart + k / 2, bStart);
		} else {
			return findKth(A, B, k - k / 2, aStart, bStart + k / 2);
		}
	}
}
