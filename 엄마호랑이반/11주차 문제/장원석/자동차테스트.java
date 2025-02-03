import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 자동차테스트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		Map<Long, Integer> map = new HashMap<>();

		long[] array = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(array);

		for (int i = 0; i < n; i++) {
			map.put(array[i], i);
		}

//		System.out.println(Arrays.toString(array));

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < q; i++) {
			long target = Long.parseLong(br.readLine());

			if (map.containsKey(target)) {
				int index = map.get(target);
				sb.append(index * (n - 1 - index)).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
