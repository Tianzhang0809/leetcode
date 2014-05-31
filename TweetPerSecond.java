public class TweetPerSecond {

	public static void main(String[] args) {

	}

	public static void tweets_per_second(Integer[] tps, Integer k) {
		for (int end = 0; end < tps.length; end++) {
			int start = Math.max(0, end - k + 1);
			int max = 0;
			for (int i = start; i <= end; i++) {
				max = Math.max(max, tps[i]);
			}
			System.out.println(max);
		}

		// Integer[] newtps = new Integer[tps.length + k];
		// // init
		// for (int i = 0; i < k - 1; i++) {
		// newtps[i] = 0;
		// }
		//
		// for (int i = k - 1; i < newtps.length - 1; i++) {
		// newtps[i] = tps[i - k + 1];
		// }

	}
}
