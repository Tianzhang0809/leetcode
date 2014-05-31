import java.util.ArrayList;

/**
 * Given 5 numbers - 1, 2, 3, 4 and 5, print out different sequence of the 5
 * numbers. 4 can not be the third one, 3 and 5 can not be adjacent. How many
 * different combinations?
 * 
 * @author oliviazhang
 * 
 */
public class Permutation_Adjust {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 }; // originally it is 120 results but after
										// applying the business logic we only
										// get 56
		ArrayList<ArrayList<Integer>> res = getPermute(arr);
		for (ArrayList<Integer> list : res) {
			System.out.println(list);
		}
		System.out.println(res.size());

	}

	public static ArrayList<ArrayList<Integer>> getPermute(int[] arr) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(res, list, arr);
		return res;

	}

	public static void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, int[] arr) {

		if (list.size() == arr.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (list.contains(arr[i])) {
				continue;
			}

			// add business logic here
			if (arr[i] == 4 && list.size() == 2) {
				continue;
			}

			if (list.size() != 0 && list.get(list.size() - 1) == 3
					&& arr[i] == 5) {
				continue;
			}

			if (list.size() != 0 && list.get(list.size() - 1) == 5
					&& arr[i] == 3) {
				continue;
			}

			list.add(arr[i]);
			helper(res, list, arr);
			list.remove(list.size() - 1);
		}
	}

}
