import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지 {

	static int N, cnt = 1;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<>();
		int number = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {

					visit[i][j] = true;
					dfs(i, j);
					list.add(cnt);
					cnt = 1;
					number++;
				}
			}
		}

		Collections.sort(list);
		System.out.println(number);
		for (int i : list) {
			System.out.println(i);
		}
	}

	private static void dfs(int x, int y) {

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			if (visit[nx][ny])
				continue;

			if (map[nx][ny] == 0)
				continue;

			visit[nx][ny] = true;
			cnt++;
			dfs(nx, ny);
		}
	}
}
