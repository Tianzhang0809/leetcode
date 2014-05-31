import java.util.ArrayList;

public class GenerateParentheses {

	public static void main(String[] args) {
		ArrayList<String> res = generateParenthesis(3);
		System.out.println(res);

	}

	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		if (n < 1) {
			return res;
		}

		helper(res, "", n, n);
		return res;
	}

	public static void helper(ArrayList<String> res, String s, int left,
			int right) {
		if (left == 0 && right == 0) {
			res.add(s);
			return;
		}

		if (left == 0) {
			helper(res, s + ")", left, right - 1);
			return;
		}

		if (left > right || right == 0) {
			return;
		}

		helper(res, s + "(", left - 1, right);
		helper(res, s + ")", left, right - 1);
	}

}
