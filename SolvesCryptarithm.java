import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SolvesCryptarithm {
	public static void main(String[] args) {
		String s = "SEND+MORE=MONEY";
		String t = "OMY--ENDRS";
		boolean res = solvesCryptarithm(s, t);
		System.out.println(res);
	}

	public static boolean solvesCryptarithm(String puzzle, String solu) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < solu.length(); i++) {
			if (solu.charAt(i) != '-') {
				map.put(solu.charAt(i), i);
			}
		}
		System.out.println(map);
		StringBuilder sb = new StringBuilder();
		String operators = "+-*/";
		char sign = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < puzzle.length(); i++) {
			char c = puzzle.charAt(i);
			if (Character.isAlphabetic(c)) {
				sb.append(map.get(c));
			} else {
				if (operators.contains(c + "")) {
					sign = c;
				}
				q.offer(Integer.parseInt(sb.toString()));
				sb = new StringBuilder();
			}
		}
		q.offer(Integer.parseInt(sb.toString()));
		int first = q.poll();
		int second = q.poll();
		int res = q.poll();
		System.out.println(first + " " + second + " " + res);
		switch (sign) {
		case '+':
			return (first + second) == res;
		case '-':
			return (first - second) == res;
		case '*':
			return (first * second) == res;
		case '/':
			return (first / second) == res;
		default:
			return false;
		}

	}

}
