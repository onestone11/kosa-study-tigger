import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] beforeArr;
    static int[][] backupBeforeArr;
    static int[][] afterArr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void dfs(int x, int y, int newValue, int originValue) {
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || beforeArr[x][y] != originValue) return;

        visited[x][y] = true;
        beforeArr[x][y] = newValue;

        for(int i=0; i<dx.length; i++) {
            dfs(x+dx[i], y+dy[i], newValue, originValue);
        }
    }

    static boolean check() {
        boolean result = true;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(beforeArr[i][j] != afterArr[i][j]) return !result;
            }
        }
        return result;
    }

    static void init() {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                beforeArr[i][j] = backupBeforeArr[i][j];
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());       // 세로
        m = Integer.parseInt(st.nextToken());       // 가로
        beforeArr = new int[m][n];
        backupBeforeArr = new int[m][n];
        afterArr = new int[m][n];
        visited = new boolean[m][n];

        for(int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<m; x++) {
                int temp = Integer.parseInt(st.nextToken());
                beforeArr[x][y] = temp;
                backupBeforeArr[x][y] = temp;
            }
        }

        for(int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<m; x++) {
                afterArr[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dfs(i, j, afterArr[i][j], beforeArr[i][j]);

                if(check()) {
                    System.out.println("YES");
                    return;
                }

                init();
            }
        }
        System.out.println("NO");
    }
}
