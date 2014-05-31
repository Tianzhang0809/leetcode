public class N_QueenII {
	public static void main(String[] args) {
		int n = 4;
		int out = totalNQueens(n);
		System.out.println(out);
	}

	private static int sum;

	public static int totalNQueens(int n) {
		sum = 0;
		int[] visted = new int[n];
		placeQueen(visted, 0);
		return sum;
	}

	public static boolean isValid(int[] visited, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (visited[i] == col) {
				return false;
			}
			if (visited[i] + i == col + row) {
				return false;
			}

			if (visited[i] - i == col - row) {
				return false;
			}
		}
		return true;
	}

	public static void placeQueen(int[] visited, int row) {
		int n = visited.length;

		if (row == n) {
			sum++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isValid(visited, row, i)) {
				visited[row] = i;
				placeQueen(visited, row + 1);
			}
		}
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
