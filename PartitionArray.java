import java.util.ArrayList;

public class PartitionArray {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(2);
		list.add(1);

		System.out.println(partitionArray(list, 2));
		System.out.println(list);

	}

	public static int partitionArray(ArrayList<Integer> nums, int k) {
		if (nums == null || nums.size() == 0) {
			return 0;
		}

		int leftBound = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) < k) {
				swap(nums, i, leftBound);
				leftBound++;
			}
		}
		return leftBound;
	}

	public static void swap(ArrayList<Integer> nums, int i, int j) {
		int tmp = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, tmp);
	}
}
