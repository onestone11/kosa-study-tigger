package Programmers.LV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤고르기 {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 }));
		System.out.println(solution(4, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 }));
		System.out.println(solution(2, new int[] { 1, 1, 1, 1, 2, 2, 2, 3 }));
	}

	private static int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : tangerine) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		List<Integer> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, (o1, o2) -> {
			return Integer.compare(map.get(o2), map.get(o1));
		});

		int cnt = 0;
		while (k > 0) {
			k -= map.get(keyList.get(cnt));
			cnt++;
		}

		return cnt;
	}
}
