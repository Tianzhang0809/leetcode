public class LengthOfLastWord {
	public static void main(String[] args) {
		String s = " ";
		int out = lengthOfLastWord(s);
		System.out.println(out);
	}

	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		String[] str_arr = s.split(" ");
		if (str_arr.length == 0) {
			return 0;
		}
		return str_arr[str_arr.length - 1].length();
	}
}
