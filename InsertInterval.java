import java.util.ArrayList;

public class InsertInterval {

	public static void main(String[] args) {
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(6, 9);
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);

		ArrayList<Interval> res = insert(list, new Interval(2, 5));
		for (Interval i : res) {
			System.out.println(i.start + " " + i.end);
		}

	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// check null
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}

		int pos = 0;
		// traverse the arraylist to see if there is overlap between newinterval
		// and the current one
		for (int i = 0; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.end < newInterval.start) {
				pos++;
				res.add(curr);
			} else if (curr.start > newInterval.end) {
				res.add(curr);
			} else {
				newInterval.start = Math.min(curr.start, newInterval.start);
				newInterval.end = Math.max(curr.end, newInterval.end);
			}
		}

		res.add(pos, newInterval);
		return res;
	}

}
