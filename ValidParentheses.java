import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		String s = "([)]";
		boolean a = isValid(s);
		System.out.println(a);
	}

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		String operators = "({[";
		Stack<Character> stack = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (operators.contains(c + "")) {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				char tmp = stack.pop();
				if (!isValid(tmp, c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static boolean isValid(char p, char q) {
		return (p == '(' && q == ')') || (p == '{' && q == '}')
				|| (p == '[' && q == ']');
	}
}
