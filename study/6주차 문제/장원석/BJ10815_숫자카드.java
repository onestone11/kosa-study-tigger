import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ10815_숫자카드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int m = Integer.parseInt(st.nextToken());
			if (map.containsKey(m))
				sb.append(1);
			else
				sb.append(0);

			sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
