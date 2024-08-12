package main.java.org.example.codingtest;

import java.util.*;
import java.io.*;

// 체스판 다시 칠하기
public class BJ_1018 {
    static String[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        board = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp[j];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                res = Math.min(res, Math.min(isBlack(i, j), isWhite(i, j)));
            }
        }
        System.out.println(res);
    }

    public static int isBlack(int i, int j) {
        int cnt = 0;
        for (int x = i; x < i + 8; x++) {
            for (int y = j; y < j + 8; y++) {
                if ((x + y) % 2 == 0 && "W".equals(board[x][y])) cnt++;
                if ((x + y) % 2 != 0 && "B".equals(board[x][y])) cnt++;
            }
        }

        return cnt;
    }

    public static int isWhite(int i, int j) {
        int cnt = 0;
        for (int x = i; x < i + 8; x++) {
            for (int y = j; y < j + 8; y++) {
                if ((x + y) % 2 == 0 && "B".equals(board[x][y])) cnt++;
                if ((x + y) % 2 != 0 && "W".equals(board[x][y])) cnt++;
            }
        }

        return cnt;
    }
}
