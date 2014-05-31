import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public static void main(String[] args) {
		char[][] board = { { 'X', 'O', 'X', 'X' }, { 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X' } };
		// printBoard(board);
		solve_9(board);
		for (char[] c_arr : board) {
			for (char c : c_arr) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}

	private static Queue<Integer> queue = null;
	private static char[][] board;
	private static int rows = 0;
	private static int cols = 0;

	public static void solve_9(char[][] board) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (board.length == 0 || board[0].length == 0)
			return;
		queue = new LinkedList<Integer>();
		board = board;
		rows = board.length;
		cols = board[0].length;

		for (int i = 0; i < rows; i++) { // **important**
			enqueue(i, 0);
			enqueue(i, cols - 1);
		}

		for (int j = 1; j < cols - 1; j++) { // **important**
			enqueue(0, j);
			enqueue(rows - 1, j);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int x = cur / cols, y = cur % cols;

			if (board[x][y] == 'O') {
				board[x][y] = 'D';
			}

			enqueue(x - 1, y);
			enqueue(x + 1, y);
			enqueue(x, y - 1);
			enqueue(x, y + 1);
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'D')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}

		queue = null;
		board = null;
		rows = 0;
		cols = 0;
	}

	public static void enqueue(int x, int y) {
		if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O') {
			queue.offer(x * cols + y);
		}
	}

	/**************************************
	 * using dfs
	 * 
	 * @param row
	 * @param col
	 * @param m
	 * @param n
	 * @param board
	 */
	public static void dfs(int row, int col, int m, int n, char[][] board) {
		if (row >= m || row < 0 || col >= n || col < 0
				|| board[row][col] != 'O') {
			return;
		}

		board[row][col] = '+';
		dfs(row - 1, col, m, n, board);
		dfs(row + 1, col, m, n, board);
		dfs(row, col - 1, m, n, board);
		dfs(row, col + 1, m, n, board);
	}

	public static void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		// scan the four edges
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) { // row
			dfs(i, 0, m, n, board); // first column
			dfs(i, n - 1, m, n, board);
		}

		for (int i = 0; i < n; i++) { // row
			dfs(0, i, m, n, board); // first row
			dfs(m - 1, i, m, n, board); // last row
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if ((board[i][j] == '+')) {
					board[i][j] = 'O';
				}
			}
		}

	}

	public static void printBoard(char[][] board) {
		for (char[] c_arr : board) {
			for (char c : c_arr) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
		System.out.println("---------");
	}
}
