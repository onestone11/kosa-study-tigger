package main.java.org.example.codingtest;

import java.io.*;

// 점수 계산
public class BJ_2506 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");

        int[] score = new int[n];
        score[0] = Integer.parseInt(data[0]);
        int ans = score[0];
        for (int i = 1; i < n; i++) {
            int now = Integer.parseInt(data[i]);

            if (now == 0) {
                score[i] = now;
            } else {
                score[i] = now + score[i - 1];
            }

            ans += score[i];
        }

        System.out.println(ans);
    }
}