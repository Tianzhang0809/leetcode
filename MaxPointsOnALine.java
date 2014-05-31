import java.util.HashMap;

public class MaxPointsOnALine {
	public static void main(String[] args) {
		Point a1 = new Point(0, 1);
		Point a2 = new Point(10, 2);
		Point a3 = new Point(5, 1);
		Point a4 = new Point(15, 3);
		Point a5 = new Point(10, 1);
		Point a6 = new Point(10, 2);
		Point a7 = new Point(0, 1);

		Point[] arr = new Point[7];
		arr[0] = a1;
		arr[1] = a2;
		arr[2] = a3;
		arr[3] = a4;
		arr[4] = a5;
		arr[5] = a6;
		arr[6] = a7;

		int res = maxPoints(arr);
		System.out.println(res);
	}

	public static int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return -1;
		}

		HashMap<Double, Integer> map = new HashMap<Double, Integer>();

		int max = 1;

		for (int i = 0; i < points.length; i++) {
			// shared point changed, map should be cleared and server the new
			// point
			map.clear();
			map.put((double) Integer.MIN_VALUE, 1);
			int dup = 0;
			// System.out.println(points[i].x + " " + points[i].y);
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					dup++;
					continue;
				}

				double key = (points[i].x == points[j].x) ? Integer.MAX_VALUE
						: 0.0 + ((double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x));

				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 2);
				}
			}

			// System.out.println(map);
			for (int value : map.values()) {
				if (value + dup > max) {
					max = value + dup;
				}
			}
		}
		return max;
	}
}
