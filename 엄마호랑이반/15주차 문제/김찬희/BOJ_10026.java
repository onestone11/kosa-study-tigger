import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static char[][] rgb;
    public static boolean[][] isVisited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};


    public static void dfs(int x, int y, char color) {
        if(x < 0 || x >= n || y < 0 || y >= n || isVisited[x][y] || rgb[x][y] != color) return;

        isVisited[x][y] = true;

        for(int i=0; i<dx.length; i++) {
            dfs(x+dx[i], y+dy[i], color);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rgb = new char[n][n];
        isVisited = new boolean[n][n];
        int ncb = 0;       // 적록 색약이 아닌 사람이 봤을 때의 구역 수
        int cb = 0;        // 적록 색약인 사람이 봤을 때의 구역 수

        for(int i=0; i<n; i++) {
            rgb[i] = br.readLine().toCharArray();
        }

        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                if(!isVisited[x][y]) {
                    dfs(x, y, rgb[x][y]);
                    ncb++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                isVisited[i][j] = false;
                if(rgb[i][j] == 'G') rgb[i][j] = 'R';
            }
        }

        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                if(!isVisited[x][y]) {
                    dfs(x, y, rgb[x][y]);
                    cb++;
                }
            }
        }

        System.out.println(ncb + " " + cb);
    }
}
