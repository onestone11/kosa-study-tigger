import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2624_동전바꿔주기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int[] dp = new int[T + 1];
		dp[0] = 1;

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			for (int j = T; j > 0; j--) {
				for (int q = 1; q <= n; q++) {
					if (j - p * q >= 0) {
						System.out.println(j + " / " + (j - p * q));
						dp[j] += dp[j - p * q];
					}
				}
			}

		}

//		System.out.println(Arrays.toString(dp));

		System.out.println(dp[T]);

	}
}
