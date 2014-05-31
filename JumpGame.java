import java.util.Hashtable;

public class JumpGame {
	public static void main(String[] args) {
		int[] A = { 3, 2, 1, 0, 4 };
		boolean res = canJump(A);
		System.out.println(res);
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
	}

	public static boolean canJump(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}

		boolean[] can = new boolean[A.length];
		can[0] = true;

		for (int i = 1; i < A.length; i++) {
			for (int j = 0; j < i; j++) {
				if (!can[j]) {
					continue;
				}

				if (A[j] + j >= i) {
					can[i] = true;
					break;
				}
			}
		}
		return can[A.length - 1];
	}

	public static void print(boolean[] arr) {
		for (boolean i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
