
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14509_로봇청소기 {

	static int N, M, r, c, d;
	static int[][] room;
	static boolean[][] clean;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		room = new int[N][M];
		clean = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == 1)
					clean[i][j] = true;
			}
		}

		int answer = start();

		System.out.println(answer);
	}

	private static int start() {
		int count = 0;

		while (true) {
			if (!clean[r][c]) {
				clean[r][c] = true;
				count++;
			}

			boolean canClean = false;

			for (int i = 0; i < 4; i++) {
				d = (d + 3) % 4;

				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] == 0 && !clean[nr][nc]) {
					r = nr;
					c = nc;
					canClean = true;
					break;
				}
			}

			if (!canClean) {
				int back = (d + 2) % 4;
				int nr = r + dr[back];
				int nc = c + dc[back];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] == 0) {
					r = nr;
					c = nc;
				} else {
					return count;
				}
			}
		}
	}

}
