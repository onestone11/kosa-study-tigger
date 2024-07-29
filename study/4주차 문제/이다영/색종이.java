package main.java.org.example.codingtest;

import java.io.*;

// 색종이
public class BJ_2563 {

    static int[][] white = new int[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int xRange = 0;
        int yRange = 0;
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);

            if (x+10 > xRange) xRange = x+10;
            if (y+10 > yRange) yRange = y+10;

            sticky(x, y);
        }

        int black = 0;
        for (int i = 0; i <= xRange; i++) {
            for (int j = 0; j <= yRange; j++) {
                if (white[i][j] > 0) black += 1;
            }
        }

        System.out.println(black);
    }


    public static void sticky(int x, int y) {
        for (int i = x; i < x+10; i++) {
            for (int j = y; j < y+10; j++) {
                white[i][j] += 1;
            }
        }
    }

}