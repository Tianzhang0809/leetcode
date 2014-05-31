public class SpiralMatrixII {
	public static void main(String[] args) {

		int[][] res = generateMatrix(3);
		print(res);
	}

	public static int[][] generateMatrix(int n) {
		if (n < 0) {
			return null;
		}

		int[][] res = new int[n][n];
		int count = 1;
		int x = 0;
		int y = 0;

		while (n > 0) {
			if (n == 1) {
				for (int i = 0; i < n; i++) {
					res[x++][y] = count++;
				}
			}

			// base cases
			for (int i = 0; i < n - 1; i++) {
				res[x][y++] = count++;
			}
			for (int i = 0; i < n - 1; i++) {
				res[x++][y] = count++;
			}
			for (int i = 0; i < n - 1; i++) {
				res[x][y--] = count++;
			}
			for (int i = 0; i < n - 1; i++) {
				res[x--][y] = count++;
			}
			x++;
			y++;
			n -= 2;
		}

		return res;
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
