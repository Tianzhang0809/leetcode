import java.util.Arrays;

public class ScrambleString {
	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgtae";
		boolean res = isScramble(s1, s2);
		System.out.println(res);
	}

	public static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 1 && s2.length() == 1) {
			return s1.charAt(0) == s2.charAt(0);
		}

		char[] s1ch = s1.toCharArray();
		char[] s2ch = s2.toCharArray();

		Arrays.sort(s1ch);
		Arrays.sort(s2ch);
		if (!new String(s1ch).equals(new String(s2ch))) {
			return false;
		}

		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);

			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i); // compare the first half
			System.out.println("***s11: " + s11 + " s21: " + s21 + " s12: "
					+ s12 + " s22: " + s22);
			if (isScramble(s11, s21) && isScramble(s12, s22)) {
				return true;
			}

			s21 = s2.substring(0, s2.length() - i); // compare the second half
			s22 = s2.substring(s2.length() - i);
			System.out.println("---s11: " + s11 + " s21: " + s21 + " s12: "
					+ s12 + " s22: " + s22);
			if (isScramble(s11, s22) && isScramble(s12, s21)) {
				return true;
			}
		}
		return false;
	}
}
