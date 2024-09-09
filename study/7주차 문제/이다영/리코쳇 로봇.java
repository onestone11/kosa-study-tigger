package main.java.org.example.codingtest;

import java.util.*;

// 리코쳇 로봇
public class Pro_169199 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }

    public static int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        int[][] dis = new int[n][m];
        Deque<int[]> dq = new ArrayDeque<>();
        int ex = 0; int ey = 0;

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(dis[i], -1);
            String[] tmp = board[i].split("");

            for (int j = 0; j < tmp.length; j++) {
                if ("R".equals(tmp[j])) {
                    dis[i][j] = 0;
                    dq.addLast(new int[] {i, j});
                } else if ("D".equals(tmp[j])) {
                    dis[i][j] = -2;
                } else if ("G".equals(tmp[j])) {
                    ex = i;
                    ey = j;
                }
            }
        }

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            int nowx = tmp[0];
            int nowy = tmp[1];

            if (nowx == ex && nowy == ey) {
                break;

            } else {
                for (int i = 0; i < 4; i++) {
                    int nextx = nowx + dx[i];
                    int nexty = nowy + dy[i];

                    while (true) {
                        if (0 <= nextx && nextx < n && 0 <= nexty && nexty < m &&
                            dis[nextx][nexty] != -2) {
                            nextx += dx[i];
                            nexty += dy[i];

                        } else {
                            nextx -= dx[i];
                            nexty -= dy[i];
                            break;
                        }
                    }

                    if (dis[nextx][nexty] == -1) {
                        dis[nextx][nexty] = dis[nowx][nowy] + 1;
                        dq.addLast(new int[]{nextx, nexty});
                    }
                }

            }
        }
        return dis[ex][ey];
    }
}
