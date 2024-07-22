package main.java.org.example.codingtest;

import java.io.*;

// RGB 거리
public class BJ_1149_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] val = new int[n][3];
        for(int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                val[i][j] = Integer.parseInt(data[j]);
            }
        }

        int[][] dp = new int[n][3];
        dp[0][0] = val[0][0]; dp[0][1] = val[0][1]; dp[0][2] = val[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min( dp[i-1][1], dp[i-1][2] ) + val[i][0];
            dp[i][1] = Math.min( dp[i-1][0], dp[i-1][2] ) + val[i][1];
            dp[i][2] = Math.min( dp[i-1][0], dp[i-1][1] ) + val[i][2];
        }

        System.out.println( Math.min( dp[n-1][0], Math.min( dp[n-1][1], dp[n-1][2] ) ) );
    }
}