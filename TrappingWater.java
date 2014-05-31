public class TrappingWater {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int out = trap2(arr);
		System.out.println(out);
	}

	public static int trap(int[] A) {
		int sum = 0;
		int max = -1;
		int maxIndex = -1;
		int prev;

		// find the highest bar
		for (int i = 0; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
				maxIndex = i;
			}
		}

		// process all bars left to the highest bar
		prev = 0;
		for (int i = 0; i < maxIndex; i++) {
			if (A[i] > prev) {
				System.out.println((A[i] - prev) * (maxIndex - i));
				sum += (A[i] - prev) * (maxIndex - i);
				prev = A[i];
			}
			sum -= A[i];
			System.out.println(i + " sum:" + sum);
		}
		System.out.println("-->sum:" + sum);

		// process all bars right to the highest bar
		prev = 0;
		for (int i = A.length - 1; i > maxIndex; i--) {
			if (A[i] > prev) {
				sum += (A[i] - prev) * (i - maxIndex);
				prev = A[i];
			}
			sum -= A[i];
		}

		return sum;
	}

	public static int trap2(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int res = 0;
		int[] left = new int[A.length];
		int[] right = new int[A.length];

		// left
		int max = A[0];
		left[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];// update max
				left[i] = A[i];
			} else {
				left[i] = max;
			}
		}

		// right
		max = A[A.length - 1];
		right[0] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] > max) {
				max = A[i]; // update max
				right[i] = A[i];
			} else {
				right[i] = max;
			}
		}

		// combined
		for (int i = 0; i < A.length; i++) {
			int tmp = Math.min(left[i], right[i]) - A[i];
			if (tmp > 0) {
				res += tmp;
			}
		}

		return res;
	}

}
