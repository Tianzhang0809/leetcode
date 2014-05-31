import java.util.LinkedList;
import java.util.Queue;

public class SurroundRegion {

	public static void main(String[] args) {
		// char[][] board = {{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'}, {'X',
		// 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'},
		// {'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'}};
		// char[][] board = { { 'X', 'O', 'X', 'O', 'X', 'O' },
		// { 'O', 'X', 'O', 'X', 'O', 'X' },
		// { 'X', 'O', 'X', 'O', 'X', 'O' },
		// { 'O', 'X', 'O', 'X', 'O', 'X' } };

		// char[][] board = {{'O','O'},{'O','O'}};
		char[][] board = { { 'O' } };
		solve(board);
		for (char[] c_arr : board) {
			for (char c : c_arr) {
				System.out.print(c + " ");
			}
			System.out.println();
		}

	}

	public static void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		// search four surrounding regions
		int m = board.length;
		int n = board[0].length;

		if (m == 1 || n == 1) {
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (board[0][i] == 'O' || board[0][i] == '+') {
				dfs(board, 0, i);
			}
		}

		for (int i = 0; i < m - 1; i++) {
			if (board[i][n - 1] == 'O' || board[i][n - 1] == '+') {
				dfs(board, i, n - 1);
			}
		}

		for (int i = n - 1; i >= 1; i--) {
			if (board[m - 1][i] == 'O' || board[m - 1][i] == '+') {
				dfs(board, m - 1, i);
			}
		}

		for (int i = m - 1; i >= 1; i--) {
			if (board[i][0] == 'O' || board[i][0] == '+') {
				dfs(board, i, 0);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '+') {
					board[i][j] = 'O';
				}
			}
		}

	}

	public static void dfs(char[][] board, int row, int col) {
		board[row][col] = '+';
		int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { row, col });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			row = curr[0];
			col = curr[1];
			for (int i = 0; i < moves.length; i++) {
				int newrow = moves[i][0] + row;
				int newcol = moves[i][1] + col;
				if (isValid(board, newrow, newcol)) {
					board[newrow][newcol] = '+';
					q.offer(new int[] { newrow, newcol });
				}
			}
		}
	}

	public static boolean isValid(char[][] board, int row, int col) {
		return (row >= 0 && row < board.length && col >= 0
				&& col < board[0].length && board[row][col] == 'O');
	}
}
