import java.util.ArrayList;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 } };
		ArrayList<Integer> res = spiralOrder(matrix);
		System.out.println(res);
	}

	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0;
		int y = 0;

		while (m > 0 && n > 0) { // !!! >0
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					res.add(matrix[x][y++]); // add last row
				}
				break;
			}

			if (n == 1) {
				for (int i = 0; i < m; i++) {
					res.add(matrix[x++][y]); // add last column
				}
				break;
			}

			// top: left -> right
			for (int i = 0; i < n - 1; i++) {
				res.add(matrix[x][y++]);
			}

			// right: up -> bottom
			for (int i = 0; i < m - 1; i++) {
				res.add(matrix[x++][y]);
			}

			// bottom: left -> right
			for (int i = 0; i < n - 1; i++) {
				res.add(matrix[x][y--]);
			}

			// left: bottom -> up
			for (int i = 0; i < m - 1; i++) {
				res.add(matrix[x--][y]);
			}
			// change layer
			x++;
			y++;

			m -= 2;
			n -= 2;
		}
		return res;

	}
}
