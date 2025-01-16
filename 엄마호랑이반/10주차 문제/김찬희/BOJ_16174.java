import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 이동 가능 방향 : 오른쪽, 아래
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean[][] visited;
    static int[][] board;

    public static void bfs(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();

            if(board[temp[0]][temp[1]] == -1) {
                System.out.println("HaruHaru");
                return;
            }

            for(int i=0; i<dx.length; i++) {
                int cnt = board[temp[0]][temp[1]];
                int x = temp[0] + dx[i] * cnt;
                int y = temp[1] + dy[i] * cnt;

                if(x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[] {x, y});
                }
            }
        }
        System.out.println("Hing");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String[] st = br.readLine().split(" ");
            for(int j=0; j<st.length; j++) board[i][j] = Integer.parseInt(st[j]);
        }
        bfs(n);
    }
}
