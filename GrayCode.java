import java.util.ArrayList;
import java.util.Collections;

public class GrayCode {

	public static void main(String[] args) {
		System.out.println(grayCode(3));

	}

	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n <= 1) {
			for (int i = 0; i <= n; i++) {
				res.add(i);
			}
			return res;
		}

		ArrayList<Integer> tmp = grayCode(n - 1); // recursive
		res.addAll(tmp);
		System.out.println(res + " " + n);
		Collections.reverse(tmp);
		for (int i = 0; i < tmp.size(); i++) {
			res.add(tmp.get(i) + (1 << (n - 1)));
		}
		return res;
	}
}
