import java.util.LinkedList;
import java.util.Queue;

public class GetKthMagicNumber {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			int val = getKthMagicNumber(i);
			System.out.println(val);
		}

	}

	public static int getKeth2(int k) {
		if (k < 0) {
			return 0;
		}

		int val = 0;
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();

		q3.add(1);
		for (int i = 0; i <= k; i++) {
			int v3 = q3.size() > 0 ? q3.peek() : Integer.MAX_VALUE;
			int v5 = q5.size() > 0 ? q5.peek() : Integer.MAX_VALUE;
			int v7 = q7.size() > 0 ? q7.peek() : Integer.MAX_VALUE;

			val = Math.min(v3, Math.min(v5, v7));

			if (val == v3) {
				q3.remove();
				q3.add(3 * val);
				q3.add(5 * val);
			} else if (val == v5) {
				q5.remove();
				q5.add(5 * val);
			} else {
				q7.remove();
			}

			q7.add(7 * val);
		}
		return val;
	}

	public static int getKthMagicNumber(int k) {
		if (k < 0) {
			return 0;
		}
		k--;
		if (k == 0) {
			return 1;
		}

		int val = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		addProduct(q, 1);
		for (int i = 0; i < k; i++) {
			val = removeMin(q);
			addProduct(q, val);
		}
		return val;

	}

	public static int removeMin(Queue<Integer> q) {
		int min = q.peek();
		for (int v : q) {
			if (min > v) {
				min = v;
			}
		}

		while (q.contains(min)) {
			q.remove(min);
		}

		return min;
	}

	public static void addProduct(Queue<Integer> q, int v) {
		q.add(v * 3);
		q.add(v * 5);
		q.add(v * 7);
	}

}
