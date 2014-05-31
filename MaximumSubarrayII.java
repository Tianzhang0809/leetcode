/**
 * find the two subarrays in one array that sum to the max number
 * 
 * @author oliviazhang
 * 
 */
public class MaximumSubarrayII {

	public static void main(String[] args) {
		int[] arr = { 1, 2, -1, 4, -5, 1, 1 }; // should return 1 + 2 - 1 + 4 +
												// 1 + 1 = 8
		int res = maxSubArray(arr);
		System.out.println(res);
	}

	public static int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] max1 = new int[A.length + 1];
		max1[0] = Integer.MIN_VALUE;

		int[] max2 = new int[A.length + 1];
		max2[0] = Integer.MIN_VALUE;

		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < A.length; i++) {
			sum1 += A[i];
			sum2 += A[A.length - i - 1];
			max1[i + 1] = Math.max(max1[i], sum1);
			max2[i + 1] = Math.max(max2[i], sum2);
			sum1 = Math.max(sum1, 0);
			sum2 = Math.max(sum2, 0);

		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < max1.length; i++) {
			int sum = max1[i] + max2[max1.length - 1 - i];
			max = Math.max(sum, max);
		}
		return max;
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
