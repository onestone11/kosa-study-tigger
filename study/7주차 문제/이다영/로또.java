package main.java.org.example.codingtest;

import java.io.*;

// 로또
public class BJ_6603 {
    private static int[] s;
    private static int[] chk;
    private static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] tmp = br.readLine().split(" ");
            k = Integer.parseInt(tmp[0]);
            chk = new int[6];

            if (k == 0) {
                break;

            } else {
                s = new int[k];
                for (int i = 0; i < k; i++) {
                    s[i] = Integer.parseInt(tmp[i + 1]);
                }

                sol(0, 0);
            }
            System.out.println();
        }
    }

    private static void sol(int idx, int v) {
        if (idx == 6) {
            for (int x : chk) {
                System.out.print(x + " ");
            }
            System.out.println();

        } else {
            for (int i = v; i < k; i++) {
                chk[idx] = s[i];
                sol(idx + 1, i + 1);
            }
        }
    }
}
