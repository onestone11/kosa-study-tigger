package org.example.codingtest;

import java.util.*;
import java.io.*;

public class BJ_18353 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int val = 0;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			val = Math.max(val, dp[i]);
		}

		System.out.println(n - val);
	}
}
