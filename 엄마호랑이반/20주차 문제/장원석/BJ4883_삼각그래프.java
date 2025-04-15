import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4883_삼각그래프 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int k = 1;
		while (N != 0) {
			int[][] graph = new int[N][3];
			long[][] dp = new long[N][3];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][0] = 1000000;
			dp[0][1] = graph[0][1];
			dp[0][2] = graph[0][1] + graph[0][2];

			for (int i = 1; i < N; i++) {
				// 왼쪽 node 판별
				dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + graph[i][0];

				// 중앙 node 판별
				dp[i][1] = Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), Math.min(dp[i - 1][2], dp[i][0]))
						+ graph[i][1];

				// 오른쪽 node 판별
				dp[i][2] = Math.min(Math.min(dp[i - 1][1], dp[i - 1][2]), dp[i][1]) + graph[i][2];
			}

			sb.append(String.format("%d. %d\n", k, dp[N - 1][1]));

			N = Integer.parseInt(br.readLine());
			k++;
		}
		
		System.out.println(sb.toString());

	}
}
