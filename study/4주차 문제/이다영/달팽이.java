package main.java.org.example.codingtest;

import java.io.*;

// 달팽이
public class BJ_1913 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int deadLine = 1;
        int x = n / 2; int y = n / 2;
        char flag = 'u';
        int cnt = 0;
        for (int i = 1; i <= Math.pow(n, 2); i++) {
            board[x][y] = i;

            if (Math.pow(deadLine, 2) == i) {
                x += dx[3];
                y += dy[3];
                flag = 'r';
                cnt = 0;
                deadLine += 2;
                continue;
            }

            switch (flag) {
                case 'r' :
                    cnt++;
                    x += dx[0]; y += dy[0];
                    if(cnt == deadLine - 2){
                        flag = 'd';
                        cnt = 0;
                    }
                    break;

                case 'd' :
                    cnt++;
                    x += dx[1]; y += dy[1];
                    if (cnt == deadLine - 1) {
                        flag = 'l';
                        cnt = 0;
                    }
                    break;

                case 'l' :
                    cnt++;
                    x += dx[2]; y += dy[2];
                    if (cnt == deadLine -1) {
                        flag = 'u';
                        cnt = 0;
                    }
                    break;

                case 'u' :
                    x += dx[3]; y += dy[3];
                    break;
            }

        }

        int mX = 0; int mY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");

                if (board[i][j] == m) {
                    mX = i + 1;
                    mY = j + 1;
                }
            }
            System.out.println();
        }

        System.out.println(mX + " " + mY);

    }
}