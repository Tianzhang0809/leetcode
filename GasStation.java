public class GasStation {

	public static void main(String[] args) {
		int[] gas = { 5 };
		int[] cost = { 4 };
		System.out.println(canCompleteCircuit(gas, cost));

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int startIndex = 0;
		int accum = 0;
		int total = 0;

		for (int i = 0; i < gas.length; i++) {
			int curr = gas[i] - cost[i];
			if (accum >= 0) {
				accum += curr;
			} else {
				// start from here
				startIndex = i;
				accum = curr;
			}
			total += curr;
		}

		return (total >= 0) ? startIndex : -1;
	}

}
