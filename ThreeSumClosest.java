import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String[] args) {
		int[] S = { 1, 1, 1, 0 };
		int out = threeSumClosest(S, -100);
		System.out.println(out);
	}

	public static int threeSumClosest(int[] num, int target) {
		if (num == null || num.length == 0) {
			return -1;
		}

		int closet = Integer.MAX_VALUE / 2;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
				closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum
						: closet;
			}
		}
		return closet;
	}
}
