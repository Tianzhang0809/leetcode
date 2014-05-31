import java.util.ArrayList;

/**
 * 1--- 1
 * 
 * 2----21
 * 
 * 3----331
 * 
 * 4----4641 (return the sum of nth row)
 * 
 * @author oliviazhang
 * 
 */
public class PascalIII {

	public static void main(String[] args) {
		int res = pascalSum(4);
		System.out.println(res);
	}

	public static int pascalSum(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n == 0) {
			return 0;
		}
		res.add(1);

		for (int i = 1; i < n; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(i + 1);
			for (int j = 0; j < i + 1; j++) {
				tmp.add(-1);
			}
			// set first and last
			tmp.set(0, i + 1);
			tmp.set(i, res.get(i - 1));

			// set middle
			for (int j = 1; j < i; j++) {
				tmp.set(j, res.get(j - 1) + res.get(j));
			}
			res = tmp;
		}

		int sum = 0;
		for (int m : res) {
			sum += m;
		}
		return sum;
	}
}
