import java.util.ArrayList;

public class Triangle {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);
		System.out.println(triangle);
		int out = minimumTotal(triangle);
		System.out.println(out);

	}

	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int n = triangle.size();
		int[][] path = new int[n][n];
		// initialize
		for (int i = 0; i < n; i++) {
			path[n - 1][i] = triangle.get(n - 1).get(i);
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				path[i][j] = Math.min(path[i + 1][j], path[i + 1][j + 1])
						+ triangle.get(i).get(j);
			}
		}
		return path[0][0];
	}
}
