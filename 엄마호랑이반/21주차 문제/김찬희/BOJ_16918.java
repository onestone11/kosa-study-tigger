import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Bomb {
        int x;
        int y;

        public Bomb(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int r, c, n;
    static int seconds = 0;
    static boolean[][] board;
    static Queue<Bomb> queue = new LinkedList<>();


    public static void plantBomb() {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(!board[i][j]) board[i][j] = true;
            }
        }
    }

    public static void burst() {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while(!queue.isEmpty()) {
            Bomb bomb = queue.poll();
            board[bomb.x][bomb.y] = false;

            for(int i=0; i<dx.length; i++) {
                int x = bomb.x + dx[i];
                int y = bomb.y + dy[i];

                if(x >= 0 && x < r && y >= 0 && y < c) {
                    board[x][y] = false;
                }
            }
        }
    }

    public static void setBomb() {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j]) {
                    queue.offer(new Bomb(i, j));
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new boolean[r][c];

        // . -> false, O -> true
        for(int i=0; i<r; i++) {
            String[] temp = br.readLine().split("");
            for(int j=0; j<c; j++) {
                if(temp[j].equals("O")) board[i][j] = true;
            }
        }

      // 아무것도 하지 않은 1초
        seconds++;

        while(seconds < n) {
            seconds++;

            if(seconds % 2 == 0) {
                setBomb();
                plantBomb();
            } else {
                burst();
            }
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j]) sb.append("O");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
