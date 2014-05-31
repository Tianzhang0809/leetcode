import java.util.ArrayList;

public class PascalTriangleII {
	public static void main(String[] args) {
		int n = 5;
		ArrayList<Integer> res = getRow(n);
		System.out.println(res);

	}

	/**
	 * Nine chapater solution
	 * 
	 * @param numRows
	 * @return
	 */
	public static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		rowIndex += 1;
		if (rowIndex == 0) {
			return res;
		}

		res.add(1);

		for (int i = 1; i < rowIndex; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(i + 1);
			for (int j = 0; j < i + 1; j++) {
				tmp.add(-1);
			}
			tmp.set(0, res.get(0));
			tmp.set(i, res.get(i - 1));

			for (int j = 1; j < i; j++) {
				tmp.set(j, res.get(j - 1) + res.get(j));
			}
			res = tmp;
		}
		return res;
	}
}
