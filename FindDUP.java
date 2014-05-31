/**
 * Given an array of n elements which contains elements from 0 to n-1, with any
 * of these numbers appearing any number of times. Find these repeating numbers
 * in O(n) and using only constant memory space.
 * 
 * @author oliviazhang
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FindDUP {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 3, 6, 6 };
		ArrayList<Integer> list = getDup2(arr);
		System.out.println(list);
	}

	/**
	 * Time complexity: O(n) Space complexity: O(n)
	 * 
	 * @param arr
	 * @return
	 */

	public static ArrayList<Integer> getDup1(int[] arr) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (arr == null || arr.length == 0) {
			return res;
		}
		HashSet<Integer> set = new HashSet<Integer>();

		// initialize
		for (int i : arr) {
			if (set.contains(i) && !res.contains(i)) {
				res.add(i);
			} else {
				set.add(i);
			}
		}
		return res;
	}

	/**
	 * Time complexity: O(nlogn) Space complexity: O(n)
	 * 
	 * @param arr
	 * @return
	 */
	public static ArrayList<Integer> getDup2(int[] arr) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (arr == null || arr.length == 0) {
			return res;
		}

		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				res.add(arr[i]);
				while (arr[i] == arr[i - 1]) {
					i++;
					if (i == arr.length) { // reach the end
						return res;
					}
				}
			}
		}
		return res;
	}

}
