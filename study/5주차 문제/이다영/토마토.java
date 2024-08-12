package main.java.org.example.codingtest;

import java.io.*;
import java.util.*;

// 토마토
public class BJ_7576 {
    static int n;
    static int m;
    static int[][] day;
    static int[][] tomato;
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        m = Integer.parseInt(mn[0]);
        n = Integer.parseInt(mn[1]);

        day = new int[n][m];
        tomato = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            Arrays.fill(day[i], Integer.MAX_VALUE);

            for (int j = 0; j < m; j++) {
                int n = Integer.parseInt(tmp[j]);
                tomato[i][j] = n;

                if(n == -1) day[i][j] = n;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 1) {
                    day[i][j] = 0;
                    dq.addLast(new int[]{i, j});
                }
            }
        }

        checkDay();
        System.out.println(findDay());
    }

    public static void checkDay() {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while(!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            int x = now[0];
            int y = now[1];

            for (int z = 0; z < 4; z++) {
                int xx = x + dx[z];
                int yy = y + dy[z];

                if (0 <= xx && xx < n && 0 <= yy && yy < m
                    && tomato[xx][yy] == 0) {
                    tomato[xx][yy] = 1;
                    day[xx][yy] = day[x][y] + 1;
                    dq.addLast(new int[]{xx, yy});
                }
            }
        }
    }

    public static int findDay() {
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (day[i][j] == Integer.MAX_VALUE) {
                    return -1;
                }

                if (day[i][j] > res) {
                    res = day[i][j];
                }
            }
        }

        return res;
    }
}
