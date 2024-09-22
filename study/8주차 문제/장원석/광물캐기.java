import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 광물캐기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 2 },
				new String[] { "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone" }));
		System.out.println(solution(new int[] { 0, 1, 1 }, new String[] { "diamond", "diamond", "diamond", "diamond",
				"diamond", "iron", "iron", "iron", "iron", "iron", "diamond" }));
	}

	private static int solution(int[] picks, String[] minerals) {
		int answer = 0;
		int[][] table = { { 1, 1, 1 }, { 5, 1, 1 }, { 25, 5, 1 } };

		Map<String, Integer> map = new HashMap<>();
		map.put("diamond", 0);
		map.put("iron", 1);
		map.put("stone", 2);

		int totalPicks = picks[0] + picks[1] + picks[2];
		int size = Math.min(minerals.length, totalPicks * 5);
		int groupCount = (size + 4) / 5; // 올림 나눗셈

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (int i = 0; i < groupCount; i++) {
			int fatigue = 0;
			for (int j = 0; j < 5; j++) {
				int index = i * 5 + j;
				if (index >= size)
					break;
				fatigue += table[2][map.get(minerals[index])];
			}
			pq.add(new int[] { i, fatigue });
		}

		for (int i = 0; i < 3; i++) {
			int pick = picks[i];
			
			while (pick > 0) {
				if (pq.isEmpty())
					return answer;

				int[] group = pq.poll();
				for (int j = 0; j < 5; j++) {
					int index = group[0] * 5 + j;
					if (index >= size)
						break;
					answer += table[i][map.get(minerals[index])];
				}
				pick--;
			}
		}

		return answer;
	}
}
