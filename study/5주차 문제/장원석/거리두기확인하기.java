import java.util.ArrayDeque;
import java.util.Arrays;

public class 거리두기확인하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } })));
	}

	private static int[] solution(String[][] places) {
		int[] answer = new int[5];
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int T = 0; T < 5; T++) {
			boolean pos = true;
			char[][] room = new char[5][5];
			ArrayDeque<int[]> queue = new ArrayDeque<>();

			for (int i = 0; i < 5; i++) {
				String str = places[T][i];

				for (int j = 0; j < 5; j++) {
					room[i][j] = str.charAt(j);

					if (room[i][j] == 'P')
						queue.add(new int[] { i, j });
				}
			}

			Flag: while (!queue.isEmpty()) {
				int[] p = queue.poll();

				// partition check
				for (int d = 0; d < 4; d++) {
					int px = p[0] + dx[d];
					int py = p[1] + dy[d];

					if (px < 0 || py < 0 || px >= 5 || py >= 5)
						continue;

					if (room[px][py] == 'X')
						continue;
					
					if(room[px][py] == 'P') {
						pos = false;
						break Flag;
					}

					int nd = (d + 2) % 4;

					for (int dd = 0; dd < 4; dd++) {
						if (dd == nd)
							continue;

						int nx = px + dx[dd];
						int ny = py + dy[dd];

						if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
							continue;

						if (room[nx][ny] == 'P') {
							pos = false;
							break Flag;
						}

					}
				}
			}

			if (pos)
				answer[T] = 1;
			else
				answer[T] = 0;

		}

		return answer;
	}

}
