import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

	static int N;
	static int length;
	static Map<String, Integer> cart;

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "banana", "apple", "rice", "pork", "pot" },
				new int[] { 3, 2, 2, 2, 1 }, new String[] { "chicken", "apple", "apple", "banana", "rice", "apple",
						"pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana" }));

		System.out.println(solution(new String[] { "apple" }, new int[] { 10 }, new String[] { "banana", "banana",
				"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana" }));
	}

	private static int solution(String[] want, int[] number, String[] discount) {
		N = want.length;
		length = discount.length;
		cart = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			cart.put(discount[i], cart.getOrDefault(discount[i], 0) + 1);
		}

		int answer = 0;

		if (compareMap(want, number)) {
			answer++;
		}

		for (int i = 10; i < length; i++) {
			String removeItem = discount[i - 10];
			cart.put(removeItem, cart.get(removeItem) - 1);

			String addItem = discount[i];
			cart.put(addItem, cart.getOrDefault(addItem, 0) + 1);

			if (compareMap(want, number)) {
				answer++;
			}
		}

		return answer;
	}

	private static boolean compareMap(String[] want, int[] number) {
		for (int i = 0; i < N; i++) {
			if (cart.getOrDefault(want[i], 0) != number[i]) {
				return false;
			}
		}

		return true;
	}
}
