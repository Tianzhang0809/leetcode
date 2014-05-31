public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "11";
		String b = "11";
		String s = addBinary(a, b);
		System.out.println(s);
	}

	public static String addBinary(String a, String b) {
		if (a == null || b == null || a.length() == 0 || b.length() == 0) {
			return "";
		}
		int aend = a.length() - 1;
		int bend = b.length() - 1;
		String res = "";
		int carry = 0;

		while (aend >= 0 && bend >= 0) {
			int aval = a.charAt(aend) - '0';
			int bval = b.charAt(bend) - '0';
			int curr = aval + bval + carry;
			res = curr % 2 + res;
			carry = curr / 2;
			aend--;
			bend--;
		}

		while (aend >= 0) {
			int curr = a.charAt(aend) - '0' + carry;
			res = curr % 2 + res;
			carry = curr / 2;
			aend--;
		}

		while (bend >= 0) {
			int curr = b.charAt(bend) - '0' + carry;
			res = curr % 2 + res;
			carry = curr / 2;
			bend--;
		}

		if (carry != 0) {
			res = carry + res;
		}
		return res;
	}

}
