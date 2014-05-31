public class BestTimeToSell {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 11, 6, 9, 10 };
		int out = maxProfit(prices);
		System.out.println(out);
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		// DP from left to right;
		left[0] = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(prices[i], min);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}
		print(left);

		// DP from right to left;
		right[right.length - 1] = 0;
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(prices[i], max);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}
		print(right);

		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(left[i] + right[i], profit);
		}
		return profit;
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
