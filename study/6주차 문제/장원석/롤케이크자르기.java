import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤케이크자르기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 1, 3, 1, 4, 1, 2 }));
		System.out.println(solution(new int[] { 1, 2, 3, 1, 4 }));
	}

	private static int solution(int[] topping) {

		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();

		for (int n : topping) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		for (int n : topping) {
			set.add(n);
			map.put(n, map.getOrDefault(n, 0) - 1);
			if (map.get(n) == 0) {
				map.remove(n);
			}

			if (set.size() == map.size()) {
				answer++;
			}
		}
		return answer;
	}

}
