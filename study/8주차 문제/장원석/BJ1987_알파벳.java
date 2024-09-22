import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1987
 * 골드4 알파벳
 */

public class BJ1987_알파벳 {

	static int R, C;
	static int max = Integer.MIN_VALUE;

	static char[][] board;
	static boolean[][] visit;
	static boolean[] alpha;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visit = new boolean[R][C];
		alpha = new boolean[26];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		visit[0][0] = true;
		alpha[board[0][0] - 'A'] = true;

		dfs(0, 0, 1);

		System.out.println(max);
	}

	private static void dfs(int x, int y, int m) {
		max = Math.max(max, m);

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;

			if (visit[nx][ny])
				continue;

			int alphaIndex = board[nx][ny] - 'A';
			if (alpha[alphaIndex])
				continue;

			visit[nx][ny] = true;
			alpha[alphaIndex] = true;

			dfs(nx, ny, m + 1);

			visit[nx][ny] = false;
			alpha[alphaIndex] = false;
		}
	}
}
