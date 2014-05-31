public class InPlaceArrayManip {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 6, 4, -1, -10, -3, 5 };
		inPlaceChange(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void inPlaceChange(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}

		int left = 0;
		int i = 0;
		while (i < arr.length) {
			if (arr[i] < 0) {
				swap(arr, i, left);
				left++;
			}
			i++;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
