import java.util.ArrayList;

public class N_Queen {

	public static void main(String[] args) {

		ArrayList<String[]> out = solveNQueens(4);
		for (String[] s_arr : out) {
			for (String s : s_arr) {
				System.out.println(s);
			}
			System.out.println();
		}

	}

	public static String[] drawBoard(ArrayList<Integer> cols) {
		String[] res = new String[cols.size()];
		for (int i = 0; i < cols.size(); i++) {
			String tmp = "";
			for (int j = 0; j < cols.size(); j++) {
				if (cols.get(i) == j) {
					tmp += "Q";
				} else {
					tmp += ".";
				}
			}
			res[i] = tmp;
		}
		return res;
	}

	public static boolean isValid(int col, ArrayList<Integer> cols) {
		int row = cols.size();

		for (int i = 0; i < row; i++) {
			if (cols.get(i) == col) {
				return false;
			} else if (cols.get(i) + i == col + row) {
				return false;
			} else if (cols.get(i) - i == col - row) {
				return false;
			}
		}
		return true;
	}

	public static void search(ArrayList<String[]> res, ArrayList<Integer> list,
			int n) {
		if (list.size() == n) {
			res.add(drawBoard(list));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isValid(i, list)) {
				continue;
			}

			list.add(i);
			search(res, list, n);
			list.remove(list.size() - 1);

		}

	}

	public static ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		if (n <= 0) {
			return res;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		search(res, list, n);
		return res;
	}

}
