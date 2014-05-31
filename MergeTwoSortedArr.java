public class MergeTwoSortedArr {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0, 0 };
		int[] B = { 0, 1, 2, 4 };
		merge(A, 6, B, 4);
		for (int i : A) {
			System.out.print(i + " ");
		}
	}

	public static void merge(int A[], int m, int B[], int n) {
		if (A == null || B == null || A.length == 0 || B.length == 0) {
			return;
		}
		int index = m + n - 1;

		while (m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1]) {
				A[index--] = A[m - 1];
				m--;
			} else {
				A[index--] = B[n - 1];
				n--;
			}
		}
		while (n > 0) {
			A[index] = B[n - 1];
			n--;
			index--;
		}
	}

}
