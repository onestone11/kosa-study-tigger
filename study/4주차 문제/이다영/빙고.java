package main.java.org.example.codingtest;

import java.io.*;

// 빙고
public class BJ_2578 {
    static int[][] bingo = new int[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(data[j]);
            }
        }

        int cnt = 0;
        total:
        for (int i = 0; i < 5; i++) {
            String[] data = br.readLine().split(" ");

            for (int j = 0; j < 5; j++) {
                cnt += 1;
                find(Integer.parseInt(data[j]));

                if(cnt >= 12 && check() >= 3) {
                    System.out.println(cnt);
                    break total;
                }
            }
        }
    }

    public static void find(int x) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == x) {
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }

    public static int check() {
        int done = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < 5; i++) {
            int row = 0; int col = 0;
            for (int j = 0; j < 5; j++) {
                row += bingo[i][j];
                col += bingo[j][i];

                if (i == j) left += bingo[i][j];
                if (i + j == 4) right += bingo[i][j];
            }

            if (row == 0) done += 1;
            if (col == 0) done += 1;
        }
        if (left == 0) done += 1;
        if (right == 0) done += 1;

        return done;
    }
}
