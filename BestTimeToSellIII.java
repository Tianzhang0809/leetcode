public class BestTimeToSellIII {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 9, 10, 8, 6, 9 };
		int res = maxProfit(arr);
		System.out.println(res);
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		// left to right
		left[0] = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]); // the minimum price so far..
			left[i] = Math.max(left[i - 1], prices[i] - min); // how much AT
																// LEAST we can
																// earn so far
		}

		// right to left
		right[right.length - 1] = 0;
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]); // the maximum price so far..
			right[i] = Math.max(right[i + 1], max - prices[i]); // how much AT
																// MOST we can
																// earn so far
		}

		print(left);
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
