package main.java.org.example.others;

import java.io.*;
import java.util.*;

// 나이트의 이동
public class BJ_7562 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] dx = new int[] {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int xx = Integer.parseInt(st2.nextToken());
            int yy = Integer.parseInt(st2.nextToken());

            int[][] chess = new int[a][a];
            int[][] chk = new int[a][a];
            Deque<int[]> dq = new ArrayDeque<>();
            dq.addLast(new int[]{x, y});
            chess[x][y] = 1;
            while(!dq.isEmpty()) {
                int[] now = dq.removeFirst();
                int nowX = now[0];
                int nowY = now[1];

                if (nowX == xx && nowY == yy) {
                    System.out.println(chk[xx][yy]);
                    break;
                }

                for (int z = 0; z < 8; z++) {
                    int nextX = nowX + dx[z];
                    int nextY = nowY + dy[z];

                    if (0 <= nextX && nextX < a &&
                        0 <= nextY && nextY < a &&
                        chess[nextX][nextY] == 0) {

                        dq.addLast(new int[]{nextX, nextY});
                        chk[nextX][nextY] = chk[nowX][nowY] + 1;
                        chess[nextX][nextY] = 1;
                    }
                }
            }
        }
    }
}
