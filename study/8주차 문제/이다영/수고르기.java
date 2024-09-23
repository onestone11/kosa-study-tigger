package main.java.org.example.codingtest;

import java.io.*;
import java.util.*;

// 수고르기
public class BJ_2230 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int s = 0; int e = 1;
        int res = Integer.MAX_VALUE;
        while (s <= e && e < n) {
            int tmp = arr[e] - arr[s];

            if (tmp >= m) {
                res = Math.min(res, tmp);
                s += 1;

                if (tmp == m) {
                    break;
                }

            } else {
                e += 1;
            }
        }

        System.out.println(res);
    }
}
