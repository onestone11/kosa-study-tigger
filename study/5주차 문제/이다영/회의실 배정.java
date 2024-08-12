package main.java.org.example.codingtest;

import java.io.*;
import java.util.*;

// 회의실 배정
public class BJ_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> meeting = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int e = Integer.parseInt(tmp[1]);
            meeting.add(new int[]{s, e});
        }

        meeting.sort(Comparator.comparingInt((int[] a) -> a[1])
                .thenComparing(a -> a[0]));

        int cnt = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int[] tmp = meeting.get(i);
            int now = tmp[0];

            if (now >= pre) {
                cnt++;
                pre = tmp[1];
            }
        }

        System.out.println(cnt);
    }
}
