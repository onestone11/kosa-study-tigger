import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍 {

	/*
	 * 1 1 / 2 3 / 2 4 / 3 4
	 */

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 100, 180, 360, 100, 270 }));
		System.out.println(solution(new int[] { 100, 100, 100 }));

	}

	private static long solution(int[] weights) {
		long answer = 0;

		Arrays.sort(weights);

		Map<Double, Integer> map = new HashMap<>();

		for (double weight : weights) {

			if (map.containsKey(weight))
				answer += map.get(weight); // 1:1
			if (map.containsKey(weight * 2 / 3))
				answer += map.get(weight * 2 / 3); // 2:3
			if (map.containsKey(weight * 1 / 2))
				answer += map.get(weight * 1 / 2); // 1:2
			if (map.containsKey(weight * 3 / 4))
				answer += map.get(weight * 3 / 4); // 3:4

			map.put(weight, map.getOrDefault(weight, 0) + 1);
		}

		return answer;
	}
}
