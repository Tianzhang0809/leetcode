

public class LongestValidParen {

	public static void main(String[] args) {
		String s = "(()";
		System.out.println(longestValidParentheses(s));

	}
	
	public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
       return -1;
    }

}
