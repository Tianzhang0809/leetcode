public class RotateImage {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		print(matrix);
		System.out.println();
		rotate(matrix);
		print(matrix);
	}

	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int n = matrix.length;
		// layer by layer rotation
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			System.out.println(first + " " + last);
			// for each layer, cell by cell
			for (int i = first; i < last; i++) {
				int offset = i - first;
				// save top
				int top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
				print(matrix);
				System.out.println();
			}
		}
	}

	public static void print(int[][] matrix) {
		for (int[] arr : matrix) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
