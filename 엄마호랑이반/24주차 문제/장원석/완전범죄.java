import java.util.Arrays;

public class 완전범죄 {

	static final int INF = 1000;

	public static void main(String[] args) {

		System.out.println(solution(new int[][] { { 1, 2 }, { 2, 3 }, { 2, 1 } }, 4, 4));
		System.out.println(solution(new int[][] { { 1, 2 }, { 2, 3 }, { 2, 1 } }, 1, 7));
		System.out.println(solution(new int[][] { { 3, 3 }, { 3, 3 } }, 7, 1));
		System.out.println(solution(new int[][] { { 3, 3 }, { 3, 3 } }, 6, 1));
	}

	/*
		 dp[i][j] = min( 
			 dp[i - 1][j] + a[i], 	// A가 훔친 경우 (B 흔적 그대로)
			 dp[i - 1][j - b[i]] 						// B가 훔친 경우 (B 흔적 증가) 
		 )
	 */

	private static int solution(int[][] info, int n, int m) {
		int size = info.length;
		int[][] dp = new int[size + 1][m];

		for (int i = 0; i <= size; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[0][0] = 0;

		for (int i = 1; i <= size; i++) {
			int a = info[i - 1][0];
			int b = info[i - 1][1];

			for (int j = 0; j < m; j++) {
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);

				if (j + b < m)
					dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
			}
		}

		int answer = n;
		for (int j = 0; j < m; j++) {
			answer = Math.min(answer, dp[size][j]);
		}

		return answer >= n ? -1 : answer;
	}
}
