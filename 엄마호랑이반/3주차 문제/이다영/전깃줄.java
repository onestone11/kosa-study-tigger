package org.example.codingtest;

import java.io.*;
import java.util.*;

public class BJ_2565 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Map<Integer, Integer> line = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			line.put(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}

		int idx = 0;
		int[] arr = new int[n];
		for (int l : line.keySet()) {
			arr[idx] = line.get(l);
			idx++;
		}

		int val = 0;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			val = Math.max(val, dp[i]);
		}

		System.out.println(n - val);
	}
}
