import java.util.ArrayList;

public class PascalTriangle {
	public static void main(String[] args) {
		int n = 6;
		ArrayList<ArrayList<Integer>> res = generate(n);
		for (ArrayList<Integer> list : res) {
			System.out.println(list);
		}
	}

	/**
	 * Nine chapater solution
	 * 
	 * @param numRows
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0) {
			return res;
		}
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(1);
		res.add(first);

		for (int i = 1; i < numRows; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(i + 1);

			for (int j = 0; j < i + 1; j++) {
				tmp.add(-1);
			}
			ArrayList<Integer> prev = res.get(i - 1);
			tmp.set(0, prev.get(0)); // first
			tmp.set(i, prev.get(i - 1)); // last
			for (int j = 1; j < i; j++) {
				tmp.set(j, prev.get(j - 1) + prev.get(j));
			}
			res.add(tmp);
		}
		return res;

	}

	/**
	 * my solution
	 * 
	 * @param numRows
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> generate_my(int numRows) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0) {
			return res;
		}
		int tmp = 0;
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			if (i != 0) {
				int size = res.get(i - 1).size();
				if (size == 1) {
					tmp = res.get(i - 1).get(0);
					list.add(tmp);
				} else {
					for (int j = 0; j < size - 1; j++) {
						tmp = res.get(i - 1).get(j) + res.get(i - 1).get(j + 1);
						list.add(tmp);
					}
					list.add(1);
				}
			}
			res.add(list);
		}
		return res;
	}
}
