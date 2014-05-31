public class SearchInA2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		boolean out = searchMatrix(matrix, 3);
		System.out.println(out);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int start = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int end = rows * cols - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid / cols][mid % cols] == target) {
				return true;
			} else if (matrix[mid / cols][mid % cols] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
}
