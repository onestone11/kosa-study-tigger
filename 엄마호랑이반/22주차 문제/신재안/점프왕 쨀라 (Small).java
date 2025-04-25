import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static String SUCCESS_MESSAGE = "HaruHaru";
    static String FAIL_MESSAGE = "Hing";
    static int[][] area;
    static int N;
    static boolean success = false;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(success ? SUCCESS_MESSAGE : FAIL_MESSAGE);

    }

    public static void dfs(int x, int y) {
        if (x >= N || y >= N || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        int move = area[x][y];
        if (move == -1) {
            success = true;
            return;
        }

        dfs(x + move, y);
        dfs(x, y + move);
    }
}
