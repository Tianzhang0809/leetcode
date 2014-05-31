public class RemoveDupFromSortedArray {

	public static void main(String[] args) {
		int[] res = { 1, 1, 1, 3, 4, 5 };

		int out = removeDuplicates(res);

		System.out.println(out);

		for (int i = 0; i < out; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int index = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1]) {
				index++;
			} else if (index > 0) {
				A[i - index] = A[i];
			}
		}
		return A.length - index;
	}

}
