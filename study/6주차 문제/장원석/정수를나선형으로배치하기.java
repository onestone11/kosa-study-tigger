import java.util.Arrays;

public class 정수를나선형으로배치하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(4)));
		System.out.println(Arrays.deepToString(solution(5)));
	}

	private static int[][] solution(int n) {
		int[][] answer = new int[n][n];
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int x = 0;
		int y = 0;
		int d = 0;

		for (int i = 1; i <= n * n; i++) {
			answer[x][y] = i;
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || answer[nx][ny] != 0) {
				d++;
				if (d > 3)
					d = 0;

				nx = x + dx[d];
				ny = y + dy[d];
			}

			x = nx;
			y = ny;
		}

		return answer;
	}
}
