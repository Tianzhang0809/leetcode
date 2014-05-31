import java.util.ArrayList;

public class RestoreIPAddress {

	public static void main(String[] args) {
		String s = "25525511135";
		ArrayList<String> res = restoreIpAddresses(s);
		System.out.println(res);

	}

	public static ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		helper(res, list, s, 0);
		return res;
	}

	public static void helper(ArrayList<String> res, ArrayList<String> list,
			String s, int start) {
		if (list.size() == 4) {
			if (start != s.length()) {
				return;
			}
			StringBuilder sb = new StringBuilder();
			for (String str : list) {
				sb.append(str).append(".");
			}
			sb.deleteCharAt(sb.length() - 1);
			res.add(sb.toString());
			return;
		}

		for (int i = start + 1; i <= s.length() && i <= start + 3; i++) {
			String sub = s.substring(start, i);
			if (isValid(sub)) {
				list.add(sub);
				helper(res, list, s, i);
				list.remove(list.size() - 1);
			}
		}
	}

	public static boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return s.equals("0");
		} else {
			int num = Integer.valueOf(s);
			return num <= 255 && num >= 0;
		}
	}

}
