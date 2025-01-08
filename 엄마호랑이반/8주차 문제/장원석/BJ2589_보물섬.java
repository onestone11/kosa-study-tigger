import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ2589_보물섬 {

	static int N, M;
	static char[][] map;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				map[i][j] = c;
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int ans = 0;
				if (map[i][j] == 'L') {
					ans = bfs(i, j);
				}
				
				max = Math.max(max, ans);
			}
		}

		System.out.println(max);
	}

	private static int bfs(int x, int y) {
		int answer = 0;

		boolean[][] visitMap = new boolean[N][M];
		visitMap[x][y] = true;

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { x, y, 0 });

		while (!queue.isEmpty()) {
			int[] n = queue.poll();
			answer = Math.max(answer, n[2]);

			for (int d = 0; d < 4; d++) {
				int nx = n[0] + dx[d];
				int ny = n[1] + dy[d];
				int nDis = n[2] + 1;

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (map[nx][ny] != 'L')
					continue;

				if (visitMap[nx][ny])
					continue;

				queue.add(new int[] { nx, ny, nDis });
				visitMap[nx][ny] = true;
			}
		}

		return answer;
	}
}
