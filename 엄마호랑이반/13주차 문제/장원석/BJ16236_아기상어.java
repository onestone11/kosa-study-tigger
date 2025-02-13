import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16236_아기상어 {
	static int N;
	static int sharkX;
	static int sharkY;
	static int sharkSize = 2;
	static int numberOfEatenFish = 0;
	static int answer = 0;
	static int[][] map;

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			int[] nextFish = findClosestFish();
			if (nextFish == null)
				break;

			answer += nextFish[2]; // 거리 추가
			numberOfEatenFish++;

			// 상어 위치 업데이트
			sharkX = nextFish[0];
			sharkY = nextFish[1];
			map[sharkX][sharkY] = 0;

			// 상어 크기 업데이트
			if (numberOfEatenFish == sharkSize) {
				sharkSize++;
				numberOfEatenFish = 0;
			}
		}

		System.out.println(answer);
	}

	private static int[] findClosestFish() {
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { sharkX, sharkY });
		dist[sharkX][sharkY] = 0;

		int minDist = -1;
		List<int[]> list = new ArrayList<>(); // 같은 거리의 물고기들을 저장

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int currentDist = dist[x][y];

			if (map[x][y] > 0 && map[x][y] < sharkSize) {
				if (minDist == -1) {
					minDist = currentDist;
					list.add(new int[] { x, y });
				} else if (currentDist == minDist) {
					list.add(new int[] { x, y });
				}
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (dist[nx][ny] != -1 || map[nx][ny] > sharkSize)
					continue;

				dist[nx][ny] = currentDist + 1;
				queue.add(new int[] { nx, ny });
			}
		}

		if (list.isEmpty())
			return null;

		// 같은 거리의 물고기들 중에서 가장 위쪽, 왼쪽 물고기 선택
		int[] result = { N, N };
		for (int[] fish : list) {
			if (fish[0] < result[0] || (fish[0] == result[0] && fish[1] < result[1])) {
				result = fish;
			}
		}

		return new int[] { result[0], result[1], minDist };
	}
}
