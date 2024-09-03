import java.util.ArrayDeque;
import java.util.Deque;

public class 리코쳇로봇 {

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "...D..R", ".D.G...", "....D.D", "D....D.", "..D...." }));
		System.out.println(solution(new String[] { ".D.R", "....", ".G..", "...D" }));
	}

	private static int solution(String[] board) {
		int N = board.length;
		int M = board[0].length();
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		boolean[][] visit = new boolean[N][M];

		int startX = 0;
		int startY = 0;
		int goalX = 0;
		int goalY = 0;

		for (int i = 0; i < board.length; i++) {
			char[] cArray = board[i].toCharArray();
			for (int j = 0; j < cArray.length; j++) {
				if (cArray[j] == 'R') {
					startX = i;
					startY = j;
				} else if (cArray[j] == 'G') {
					goalX = i;
					goalY = j;
				}
			}
		}

		Deque<Robot> queue = new ArrayDeque<>();
		queue.add(new Robot(startX, startY, 0));
		int min = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Robot robot = queue.poll();
			if (robot.x == goalX && robot.y == goalY)
				min = Math.min(min, robot.c);

			for (int d = 0; d < 4; d++) {
				int nx = robot.x;
				int ny = robot.y;

				while (true) {
					nx += dx[d];
					ny += dy[d];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						break;

					if (board[nx].charAt(ny) == 'D')
						break;
				}

				nx -= dx[d];
				ny -= dy[d];

				if (visit[nx][ny] || (robot.x == nx && robot.y == ny))
					continue;

				queue.add(new Robot(nx, ny, robot.c + 1));
				visit[nx][ny] = true;
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}

	static class Robot {
		int x;
		int y;
		int c;

		public Robot(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
