package main.java.org.example.codingtest;

import java.io.*;
import java.util.*;

// 랜선 자르기
public class BJ_1654 {
    static int[] line;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kn = br.readLine().split(" ");
        int k = Integer.parseInt(kn[0]);
        int n = Integer.parseInt(kn[1]);

        line = new int[k];
        int maxVal = 0;
        for (int i = 0; i < k; i++) {
            line[i] = Integer.parseInt(br.readLine());

            if (line[i] > maxVal) maxVal = line[i];
        }

        long s = 1; long e = maxVal;
        long res = 0;
        while (s <= e) {
            long mid = (s + e) / 2;

            if (countLine(mid) >= n) {
                res = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        System.out.println(res);
    }

    public static long countLine(long len) {
        long cnt = 0;

        for (int x : line) {
            cnt += x / len;
        }

        return cnt;
    }
}
