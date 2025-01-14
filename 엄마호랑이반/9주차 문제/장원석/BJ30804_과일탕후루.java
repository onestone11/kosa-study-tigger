import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ30804_과일탕후루 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N <= 2) {
			System.out.println(N);
			return;
		}

		int[] candy = new int[N];
		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int s = Integer.parseInt(st.nextToken());
			candy[i] = s;
		}

		int start = 0;
		int end = 0;
		int max = 1;
		map.put(candy[0], 1);

		while (end < N - 1) {
			end++;
			map.put(candy[end], map.getOrDefault(candy[end], 0) + 1);

			// 종류가 2개를 초과하면 start를 이동
			while (map.size() > 2) {
				map.put(candy[start], map.get(candy[start]) - 1);
				if (map.get(candy[start]) == 0)
					map.remove(candy[start]);

				start++;
			}

			max = Math.max(max, end - start + 1);
		}

		System.out.println(max);
	}

}
