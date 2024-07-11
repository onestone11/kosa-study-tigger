package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7562
 * 실버1 나이트의 이동
 */

public class BJ7562_나이트의이동 {

	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int l = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			int answer = bfs(l, startX, startY, endX, endY);
			sb.append(answer).append("\n");

		}

		System.out.println(sb.toString());

	}

	public static int bfs(int l, int x, int y, int ex, int ey) {
		int depth = 0;
		boolean[][] visit = new boolean[l][l];
		visit[x][y] = true;

		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { x, y, 0 });

		while (!queue.isEmpty()) {
			int[] target = queue.poll();
			depth = target[2];

			if (target[0] == ex && target[1] == ey)
				break;

			for (int d = 0; d < 8; d++) {
				int nx = target[0] + dx[d];
				int ny = target[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= l || ny >= l)
					continue;

				if (visit[nx][ny])
					continue;

				visit[nx][ny] = true;
				queue.add(new int[] { nx, ny, depth + 1 });
			}
		}

		return depth;
	}

}
