import java.util.ArrayList;

public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return path;
		}
		String res = "/";
		ArrayList<String> list = new ArrayList<String>();
		String[] str_arr = path.split("/+");
		for (String str : str_arr) {
			if (str.equals("..")) {
				if (list.size() > 0) {
					list.remove(list.size() - 1);
				}
			} else if (!str.equals(".") && str.length() > 0) {
				list.add(str);
			}
		}

		for (String s : list) {
			res += s + "/";
		}
		if (res.length() > 1) {
			res = res.substring(0, res.length() - 1);
		}
		return res;
	}
}
