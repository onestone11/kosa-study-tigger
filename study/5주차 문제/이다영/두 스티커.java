package main.java.org.example.codingtest;

import java.io.*;
import java.util.*;

// 두 스티커
public class BJ_16937 {
    static int h;
    static int w;
    static int[][] paper;
    static List<int[]> sticker = new ArrayList<>();
    static int area = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] hw = br.readLine().split(" ");
        h = Integer.parseInt(hw[0]);
        w = Integer.parseInt(hw[1]);
        paper = new int[h][w];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);

            sticker.add(new int[]{r, c});
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sticky(i, j);
            }
        }

        System.out.println(area);
    }

    public static void sticky(int i, int j) {
        int[] stickerI = sticker.get(i);
        int[] stickerJ = sticker.get(j);
        int tmp = 0;

        total:
        for (int x = 0; x < 2; x++) {
            int w1 = stickerI[x];
            int h1 = stickerI[1 - x];

            for (int y = 0; y < 2; y++) {
                int w2 = stickerJ[y];
                int h2 = stickerJ[1 - y];

                if ( (w1 + w2 <= w && Math.max(h1, h2) <= h) ||
                    (h1 + h2 <= h && Math.max(w1, w2) <= w) ){

                    tmp = (w1 * h1) + (w2 * h2);
                    break total;
                }
            }
        }

        area = Math.max(area, tmp);
    }
}
