import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 석유시추 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 0, 0, 1, 1, 0 }, { 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 1, 1 } }));
		System.out.println(solution(new int[][] { { 1, 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 0 }, { 1, 0, 0, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1 } }));
	}

	static int N, M, count;
	static boolean[][] visited;
	static int[][] numberMap;
	static Map<Integer, Integer> size = new HashMap<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	private static int solution(int[][] land) {
		N = land.length;
		M = land[0].length;
		visited = new boolean[N][M];
	    numberMap = new int[N][M];
		int number = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				count = 0;

				if (!visited[i][j] && land[i][j] != 0) {
					dfs(i, j, number, land);
					size.put(number, count);
					number++;
				}

			}
		}

		int max = 0;
		for (int j = 0; j < M; j++) {
			int total = 0;
			Set<Integer> checkMass = new HashSet<>();

			for (int i = 0; i < N; i++) {
		        if (numberMap[i][j] > 0 && !checkMass.contains(numberMap[i][j])) {
		            checkMass.add(numberMap[i][j]);
		            total += size.get(numberMap[i][j]);
		        }
		    }

			max = Math.max(total, max);
		}

		return max;
	}

	private static void dfs(int x, int y, int number, int[][] land) {
		visited[x][y] = true;
	    numberMap[x][y] = number;
		count++;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
				continue;

			if (land[nx][ny] == 0)
				continue;

			dfs(nx, ny, number, land);
		}

	}

}
