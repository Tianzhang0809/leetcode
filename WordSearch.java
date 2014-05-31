public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String w = "SEE";
		System.out.println(exist(board, w));

	}

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (search(board, visited, word, i, j, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean search(char[][] board, boolean[][] visited,
			String word, int row, int col, int start) {
		if (word.length() == start) {
			return true;
		}

		if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
			return false;
		}

		if (word.charAt(start) != board[row][col]) {
			return false;
		}

		if (visited[row][col]) {
			return false;
		}

		visited[row][col] = true;
		boolean res = search(board, visited, word, row + 1, col, start + 1)
				|| search(board, visited, word, row - 1, col, start + 1)
				|| search(board, visited, word, row, col + 1, start + 1)
				|| search(board, visited, word, row, col - 1, start + 1);
		visited[row][col] = false;
		return res;
	}

}
