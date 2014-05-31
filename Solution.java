// To execute Java, please define "static void main" on a class
// named Solution.

class Solution {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4 };
		int[] B = { 2, 2, 4, 5 }; // 1, 2, 2, 2, 3, 4, 4, 5 --> 2.5
		double res = findMedian(A, B);
		System.out.println(res);
	}

	public static double findMedian(int[] A, int[] B) {
		// check null / error
		if (A == null || A.length == 0 || B == null || B.length == 0) {
			return 0;
		}

		int len = A.length + B.length;
		if (len % 2 == 0) {
			return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0,
					len / 2 + 1)) / 2.0;
		} else {
			return findKth(A, 0, B, 0, len / 2 + 1);
		}
	}

	public static double findKth(int[] A, int A_start, int[] B, int B_start,
			int key) {
		if (A_start >= A.length) { // basecase
			return B[B_start + key - 1];
		}
		if (B_start >= B.length) { // basecase
			return A[A_start + key - 1];
		}

		if (key == 1) {
			return Math.min(A[A_start], B[B_start]);
		}

		// the median for A and B separately
		int A_key = (A_start + key / 2 - 1 < A.length) ? A[A_start + key / 2
				- 1] : Integer.MAX_VALUE;
		int B_key = (B_start + key / 2 - 1 < B.length) ? B[B_start + key / 2
				- 1] : Integer.MAX_VALUE;

		if (A_key < B_key) { // compare the median
			return findKth(A, A_start + key / 2, B, B_start, key - key / 2);
		} else {
			return findKth(A, A_start, B, B_start + key / 2, key - key / 2);
		}

	}

}
