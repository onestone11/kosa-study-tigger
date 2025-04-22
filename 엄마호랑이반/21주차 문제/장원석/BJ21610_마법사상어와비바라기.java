import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21610_마법사상어와비바라기 {

	static int N, M;
	static int[][] map;
	static boolean[][] newCloud;
	static boolean[][] beforeCloud;

	static int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		newCloud = new boolean[N][N];
		beforeCloud = new boolean[N][N];

		beforeCloud[N - 1][0] = true;
		beforeCloud[N - 1][1] = true;
		beforeCloud[N - 2][0] = true;
		beforeCloud[N - 2][1] = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			moveCloud(d, s);

			rain();

			checkDiagonal();

			makeCloud();
		}

		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer += map[i][j];
			}
		}

		System.out.println(answer);
	}

	private static void moveCloud(int d, int s) {

		if (s > N)
			s %= N;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!beforeCloud[i][j])
					continue;

				int nx = i;
				int ny = j;

				nx += dir[d - 1][0] * s;
				ny += dir[d - 1][1] * s;

				if (nx < 0 || nx >= N) {
					nx = i - dir[d - 1][0] * (N - s);
				}

				if (ny < 0 || ny >= N) {
					ny = j - dir[d - 1][1] * (N - s);
				}

				newCloud[nx][ny] = true;

			}
		}

	}

	private static void rain() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!newCloud[i][j])
					continue;

				map[i][j]++;
			}
		}
	}

	private static void checkDiagonal() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!newCloud[i][j])
					continue;

				int x = i;
				int y = j;

				int count = 0;

				for (int d = 1; d < 8; d += 2) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;

					if (map[nx][ny] > 0)
						count++;
				}

				map[x][y] += count;
			}
		}

	}

	private static void makeCloud() {
		boolean[][] temp = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!newCloud[i][j] && map[i][j] >= 2) {
					temp[i][j] = true;
					map[i][j] -= 2;
				}
			}
		}

		beforeCloud = temp;
		newCloud = new boolean[N][N];
	}
}
