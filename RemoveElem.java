public class RemoveElem {

	public static void main(String[] args) {
		int[] arr = { 1, 2 };
		System.out.println(removeElement_better(arr, 3));

	}

	/**
	 * 
	 * @param A
	 * @param elem
	 * @return
	 */

	public static int removeElement_better(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[index] = A[i];
				index++;
			}
		}
		return index;
	}
}
