import java.util.Arrays;

public class 혼자놀기의달인 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 8, 6, 3, 7, 2, 5, 1, 4 }));
	}

	static int[] parents;

	private static int solution(int[] cards) {

		for (int i = 0; i < cards.length; i++) {
			cards[i] = cards[i] - 1;
		}

		parents = new int[cards.length];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < cards.length; i++) {
			int start = i;
			int end = cards[i];

			while (parents[start] != parents[end]) {
				union(start, end);
				start = end;
				end = cards[end];
			}
		}
		
		System.out.println(Arrays.toString(parents));

		int[] count = new int[cards.length];
		for (int i = 0; i < parents.length; i++) {
			int key = parents[i];
			if (count[key] > 0)
				continue;

			for (int j = 0; j < parents.length; j++) {
				if (key == parents[j]) {
					count[key]++;
				}
			}
		}

		Arrays.sort(count);
		return count[count.length - 1] * count[count.length - 2];
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parents[b] = a;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		else
			return parents[a] = find(parents[a]);
	}
}
