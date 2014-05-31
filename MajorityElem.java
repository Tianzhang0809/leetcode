public class MajorityElem {

	public static void main(String[] args) {
		int[] arr = { 1, 2 };
		System.out.println(findMajorityElement(arr));

	}

	public static int findMajorityElement(int[] arr) {
		int count = 0, major = -1;

		for (int i = 0; i < arr.length; i++) {
			if (count == 0) {
				major = arr[i];
			}
			if (arr[i] == major) {
				count++;
			} else {
				count--;
			}
		}

		return major;
	}

}
