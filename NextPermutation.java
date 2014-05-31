public class NextPermutation {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		nextPermutation(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	/**
	 * logic: 1. from right to left, find the first digit (partitionNumber)
	 * which violate the increasing trend 2. From right to left, find the first
	 * digit which is bigger than partitionNumber (changeNumber) 3. swap
	 * Partition number and changeNumber 4. Reverse all the digits on the right
	 * of partition index
	 * 
	 * @param num
	 */
	public static void nextPermutation(int[] num) {
		if (num == null || num.length == 0) {
			return;
		}

		int len = num.length;
		for (int i = len - 2; i >= 0; i--) {
			if (num[i + 1] > num[i]) { // when violating the increasing order
										// record the index
				int j;
				// j range -> last digit ~ i
				for (j = len - 1; j > i - 1; j--) { // first number biger than
													// the partition number
					if (num[j] > num[i]) {
						break;
					}
				}

				swap(num, i, j);
				reverse(num, i + 1, len - 1); // reverse the next letter of
												// partition number
				return;
			}
		}

		reverse(num, 0, len - 1); // if come to this step
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void reverse(int[] num, int start, int end) {
		while (start < end) {
			swap(num, start, end);
			start++;
			end--;
		}
	}
}
