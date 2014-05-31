import java.util.ArrayList;

public class Debuger {

	public static void main(String[] args) {
		String s1 = "A A A B C";
		String s2 = "B";
		String s3 = "C";
		ArrayList<String> co = new ArrayList<String>();
		co.add(s1);
		co.add(s2);
		co.add(s3);
		ArrayList<String> res = mostFrequentAppear(co);
		System.out.println(res);
	}

	public static ArrayList<String> mostFrequentAppear(
			ArrayList<String> comments) {

	}
}
