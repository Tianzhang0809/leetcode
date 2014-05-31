import java.util.Stack;

public class LargestRectangleInHisto {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 6, 2 };
		int n = largestRectangleArea(arr);
		System.out.println(n);
	}

	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		Stack<Integer> s = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i <= height.length; i++) {
			System.out.println(i + ": " + s);
			int curr = (i == height.length) ? -1 : height[i];
			while (!s.isEmpty() && curr < height[s.peek()]) { // not in the
																// increasing
																// order
				int h = height[s.pop()];
				System.out.println(s.isEmpty());
				int w = s.isEmpty() ? i : i - 1 - s.peek();
				System.out.println(h + " " + w);
				max = Math.max(max, h * w);
			}
			s.push(i);
		}
		return max;
	}
}
