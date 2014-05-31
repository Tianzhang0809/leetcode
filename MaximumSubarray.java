public class MaximumSubarray {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] res = maxSubArray(arr);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public static int[] maxSubArray(int[] A) { // return the index of start and
												// end
		if (A == null || A.length == 0) {
			return null;
		}

		int[] sum = new int[A.length];
		sum[0] = A[0];
		int max = Integer.MIN_VALUE;
		int start = -1, end = -1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > sum[i - 1] + A[i]) { // sum[i - 1] < 0
				start = i;
			}

			sum[i] = Math.max(sum[i - 1] + A[i], A[i]);
			if (sum[i] > max) {
				end = i;
			}

			max = Math.max(sum[i], max);
		}

		print(sum);
		int[] res = new int[2];
		res[0] = start;
		res[1] = end;
		return res;

	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
