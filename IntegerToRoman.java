public class IntegerToRoman {

	public static void main(String[] args) {
		// 6 -> VI
		// 4 -> IV
		System.out.println(intToRoman(1954));

	}

	public static String intToRoman(int num) {
		if (num <= 0) {
			return "";
		}
		int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };

		StringBuilder sb = new StringBuilder();
		int digit = 0;
		while (num > 0) {
			int times = num / nums[digit];
			num -= times * nums[digit];
			while (times > 0) {
				sb.append(symbols[digit]);
				times--;
			}
			digit++;
		}

		return sb.toString();
	}
}
