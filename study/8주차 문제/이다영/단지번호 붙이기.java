package main.java.org.example.codingtest;

import java.io.*;
import java.util.*;

// 단지번호 붙이기
public class BJ_2667 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] house = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                house[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (house[i][j] == 1) {
                    int cnt = 0;
                    house[i][j] = 0;

                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.addLast(new int[]{i, j});

                    while (!dq.isEmpty()) {
                        cnt++;
                        int[] tmp = dq.pollFirst();

                        for (int k = 0; k < 4; k++) {
                            int x = tmp[0] + dx[k];
                            int y = tmp[1] + dy[k];

                            if (0 <= x && x < n &&
                                0 <= y && y < n &&
                                house[x][y] == 1) {

                                house[x][y] = 0;
                                dq.addLast(new int[]{x, y});
                            }
                        }
                    }

                    ans.add(cnt);
                }
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int x : ans) {
            System.out.println(x);
        }
    }
}
