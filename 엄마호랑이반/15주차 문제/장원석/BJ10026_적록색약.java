import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10026_적록색약 {

	static int N;
	static char[][] painting;
	static boolean[][] visited;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		painting = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				painting[i][j] = line.charAt(j);
			}
		}

//		System.out.println(Arrays.deepToString(painting));

		int cnt1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, painting[i][j]);
					cnt1++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (painting[i][j] == 'G')
					painting[i][j] = 'R';
			}
		}

		visited = new boolean[N][N];

		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, painting[i][j]);
					cnt2++;
				}
			}
		}

		System.out.println(cnt1 + " " + cnt2);
	}

	private static void dfs(int x, int y, char color) {
		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			if (visited[nx][ny])
				continue;

			if (painting[nx][ny] != color)
				continue;

			dfs(nx, ny, color);
		}
	}
}
