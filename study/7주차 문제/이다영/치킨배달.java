package main.java.org.example.codingtest;

import java.util.*;
import java.io.*;

// 치킨 배달
public class BJ_15686 {
    private static int n;
    private static int m;
    private static List<int[]> house;
    private static List<int[]> pizza;
    private static int[] chk;
    private static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        chk = new int[m];
        house = new ArrayList<>();
        pizza = new ArrayList<>();
        res = Integer.MAX_VALUE;

        int[][] city = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 1; j < n + 1; j++) {
                city[i][j] = Integer.parseInt(tmp[j - 1]);

                if (city[i][j] == 1) {
                    house.add(new int[]{i, j});

                } else if (city[i][j] == 2) {
                    pizza.add(new int[]{i, j});
                }
            }
        }

        combination(0, 0);
        System.out.println(res);
    }

    public static void combination(int idx, int val) {
        if (idx == m) {
            int sum = 0;
            for (int[] tmp : house) {
                int x1 = tmp[0];
                int y1 = tmp[1];
                int dis = Integer.MAX_VALUE;

                for (int x : chk) {
                    int x2 = pizza.get(x)[0];
                    int y2 = pizza.get(x)[1];

                    dis = Math.min(dis, (Math.abs(x1 - x2) + Math.abs(y1 - y2)));
                }
                sum += dis;
            }

            if (res > sum) {
                res = sum;
            }

        } else {
            for (int i = val; i < pizza.size(); i++) {
                chk[idx] = i;
                combination(idx + 1, i + 1);
            }
        }
    }
}
