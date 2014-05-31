import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.push(5);
		s.push(1);

		System.out.println(s);
		Stack<Integer> res = sortStack(s);
		System.out.println(res);

	}

	public static Stack<Integer> sortStack(Stack<Integer> s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		Stack<Integer> buffer = new Stack<Integer>();
		while (!s.isEmpty()) {
			System.out.println(s + " " + buffer);
			int tmp = s.pop();
			while (!buffer.isEmpty() && buffer.peek() > tmp) {
				s.push(buffer.pop());
			}
			buffer.push(tmp);
		}
		return buffer;
	}

}
