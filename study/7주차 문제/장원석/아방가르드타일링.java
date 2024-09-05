import java.util.Arrays;

public class 아방가르드타일링 {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(7));
		System.out.println(solution(8));

	}

	private static int solution(int n) {
		if (n < 4)
			return n == 1 ? 1 : n == 2 ? 3 : 10;

		long[] dp = new long[n + 1];
		long[] dp4 = new long[n + 1];
		long[] dp5 = new long[n + 1];
		long[] dp6 = new long[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 10;

		for (int i = 4; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2 + dp[i - 3] * 5) % MOD;
			dp[i] = (dp[i] + func(dp, dp4, i, 4, 2)) % MOD;
			dp[i] = (dp[i] + func(dp, dp5, i, 5, 2)) % MOD;
			dp[i] = (dp[i] + func(dp, dp6, i, 6, 4)) % MOD;
		}

		System.out.println(Arrays.toString(dp4));
		System.out.println(Arrays.toString(dp5));
		System.out.println(Arrays.toString(dp6));

		return (int) dp[n];
	}

	private static long func(long[] dp, long[] dpPattern, int i, int offset, int multiplier) {
		if (i < offset) {
//			System.out.println(i + " less than " + offset);
			return 0;
		}

		long newValue = (dp[i - offset] * multiplier) % MOD;
		dpPattern[i] = (dpPattern[i - 3] + newValue) % MOD;
		return dpPattern[i];
	}
}
