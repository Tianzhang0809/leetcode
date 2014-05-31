/**
 * Given an array of n positive integers. Write a program to find the sum of
 * maximum sum subsequence of the given array such that the intgers in the
 * subsequence are sorted in increasing order. For example, if input is {1, 101,
 * 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), if the input
 * array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the
 * input array is {10, 5, 4, 3}, then output should be 10
 * 
 * @author oliviazhang
 * 
 */
public class MaximumSumsubsequence_Interview {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 10 };
		System.out.println(maxSum(arr));

	}

	public static int maxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int[] temp = new int[arr.length];

		// init
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					temp[i] += temp[j];
					if (max < temp[i]) {
						max = temp[i];
					}
					break;
				}
			}
		}
		return max;

	}

}
