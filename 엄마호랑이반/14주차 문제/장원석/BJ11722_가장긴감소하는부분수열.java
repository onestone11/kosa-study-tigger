import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		int ans = 1;
		for (int i = 1; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					max = Math.max(max, dp[j]);
				}
			}

			dp[i] = max + 1;
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}

}
