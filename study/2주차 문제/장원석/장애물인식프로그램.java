package Softeer.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 장애물인식프로그램 {

	static int N, block;
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
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

//		System.out.println(Arrays.deepToString(map));

		int[] obj = new int[N * N];
		block = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] != 0) {
					dfs(i, j);
					block++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;

				obj[map[i][j]]++;
			}
		}
		
		Arrays.sort(obj);

		int count = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N * N; i++) {
			if(obj[i] == 0)
				continue;
			
			count++;
			sb.append(obj[i]).append("\n");
		}
		
		System.out.println(count);
		System.out.println(sb.toString());
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;
		map[x][y] = block;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			if (visit[nx][ny] || map[nx][ny] == 0)
				continue;

			dfs(nx, ny);
		}

	}

}
