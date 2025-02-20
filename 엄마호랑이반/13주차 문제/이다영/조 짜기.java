import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		for (int i = 2; i < n+1; i++) {
			int max = score[i], min = score[i];
			for (int k = i-1; k > 0; k--) {
				if (max < score[k]) max = score[k];
				if (min > score[k]) min = score[k];
				
				int diff = max - min;
				dp[i] = Math.max(dp[k-1] + diff, dp[i]);
			}
		}
		System.out.print(dp[n]);
	}
}
