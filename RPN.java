import java.util.Stack;

public class RPN {
	public static void main(String[] args) {
		String[] str = { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(str));
	}

	public static int evalRPN(String[] tokens) {
		String operators = "+-*/";
		Stack<Integer> stack = new Stack<Integer>();

		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(Integer.valueOf(token));
			} else {
				Integer first = stack.pop();
				Integer second = stack.pop();
				if (token.equals("+")) {
					stack.push(first + second);
				} else if (token.equals("-")) {
					stack.push(second - first);
				} else if (token.equals("*")) {
					stack.push(first * second);
				} else if (token.equals("/")) {
					stack.push(second / first);
				}
			}
		}

		return stack.pop();
	}
}
