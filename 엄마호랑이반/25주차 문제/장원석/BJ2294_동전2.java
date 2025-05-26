import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2294_동전2 {

	static int INF = 10001;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n];
		int[] dp = new int[k + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coins);

		for (int coin : coins) {
			for (int i = coin; i <= k; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

//		System.out.println(Arrays.toString(dp));

		System.out.println(dp[k] == INF ? -1 : dp[k]);
	}

}
