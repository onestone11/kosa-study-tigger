import java.util.ArrayDeque;
import java.util.Deque;

public class 택배배달과수거하기 {

	public static void main(String[] args) {
		System.out.println(solution(4, 5, new int[] { 1, 0, 3, 1, 2 }, new int[] { 0, 3, 0, 4, 0 }));
		System.out.println(solution(2, 7, new int[] { 1, 0, 2, 0, 1, 0, 2 }, new int[] { 0, 2, 0, 1, 0, 2, 0 }));
	}

	private static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		Deque<int[]> queue1 = new ArrayDeque<>();
		Deque<int[]> queue2 = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			if (deliveries[i] != 0)
				queue1.addLast(new int[] { deliveries[i], i + 1 });

			if (pickups[i] != 0)
				queue2.addLast(new int[] { pickups[i], i + 1 });
		}

		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			int sum = 0;
			int dist = 0;

			while (!queue1.isEmpty() && sum < cap) {
				int[] delivery = queue1.pollLast();
				dist = Math.max(dist, delivery[1]);

				if (delivery[0] + sum <= cap) {
					sum += delivery[0];
				} else {
					delivery[0] -= (cap - sum);
					queue1.addLast(delivery);
					break;
				}
			}

			sum = 0;

			while (!queue2.isEmpty() && sum < cap) {
				int[] pickup = queue2.pollLast();
				dist = Math.max(dist, pickup[1]);

				if (pickup[0] + sum <= cap) {
					sum += pickup[0];
				} else {
					pickup[0] -= (cap - sum);
					queue2.addLast(pickup);
					break;
				}
			}

			answer += dist * 2;
		}

		return answer;
	}
}
