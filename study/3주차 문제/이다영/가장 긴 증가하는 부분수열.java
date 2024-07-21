package main.java.org.example.codingtest;

import java.util.*;
import java.io.*;

// 가장 긴 증가하는 부분 수열
public class BJ_11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");

        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int maxLen = dp[0];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(a[i]);

            if(i != 0) {
                for (int j = i-1; j >= 0; j--) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);

                        if (dp[i] > maxLen) {
                            maxLen = dp[i];
                        }
                    }
                }
            }
        }

        System.out.print(maxLen);
    }
}
