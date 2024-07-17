package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] seq = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			int max = 0;

			for (int j = i; j >= 0; j--) {
				if (seq[j] < seq[i]) {
					max = Math.max(max, dp[j]);
				}
			}

			dp[i] = max + 1;
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);

	}

}
