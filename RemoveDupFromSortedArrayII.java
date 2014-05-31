/**
 * when two dups are allow [not allow three]
 * 
 * @author oliviazhang
 * 
 */
public class RemoveDupFromSortedArrayII {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 2, 3 };
		int res = removeDuplicates(arr);
		System.out.println(res);

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	/**
	 * way 2
	 * 
	 * @param A
	 * @return
	 */

	public static int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int i = 0, count = 0;

		// count = 0, 2
		// i = 0, 1,
		// j = 1 2, 3

		for (int j = 1; j < A.length; j++) {
			if (A[i] == A[j] && count < 2) {
				count = 2; // has got two
				A[++i] = A[j];
			} else if (A[i] != A[j]) {
				A[++i] = A[j];
				count = 0;
			} else if (count == 2 && A[i] == A[j]) {
				continue;
			}

		}
		return i + 1;

	}
}
