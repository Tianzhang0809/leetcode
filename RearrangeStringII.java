import java.util.PriorityQueue;

public class RearrangeStringII {
	class Charfreq implements Comparable {
		int freq;
		char val;

		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			Charfreq cf = (Charfreq) o;
			return cf.freq - this.freq;
		}

		public Charfreq(char val, int freq) {
			this.val = val;
			this.freq = freq;
		}
	}

	public String reArrange(String s, int d) {
		int[] arr = new int[26];
		char[] res = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}

		PriorityQueue<Charfreq> pq = new PriorityQueue<Charfreq>(26);
		for (int i = 0; i < arr.length; i++) {
			Charfreq cf = new Charfreq((char) ('a' + i), arr[i]);
			pq.add(cf);
		}

		while (!pq.isEmpty()) {
			Charfreq cf = pq.poll();
			if (cf.freq == 0) {
				continue;
			}
			int i = 0;
			while (i < res.length && res[i] != '\0') {
				i++;
			}
			while (i < res.length && cf.freq > 0) {
				res[i] = cf.val;
				i += d;
				cf.freq--;
			}

			if (cf.freq > 0) {
				return null;
			}

		}

		return new String(res);
	}

	public static void main(String[] args) {
		RearrangeStringII rearrange = new RearrangeStringII();
		System.out.println(rearrange.reArrange("add", 3));

	}
}