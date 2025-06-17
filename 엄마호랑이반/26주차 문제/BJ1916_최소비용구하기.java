import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1916_최소비용구하기 {

	static int N;
	static boolean[] visited;
	static long[] dijkstra;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// map[i][j] : 도시 i에서 j로 가는데 드는 최소 비용
		long[][] map = new long[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					map[i][j] = 0;
					continue;
				}

				map[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			int val = Integer.parseInt(st.nextToken());

			map[row][col] = Math.min(map[row][col], val);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken()) - 1;
		int to = Integer.parseInt(st.nextToken()) - 1;

		// start부터 시작해서 모든 도시로 가는 배열
		dijkstra = map[start].clone();

		visited = new boolean[N];
		visited[start] = true;

		for (int i = 1; i < N; i++) {
			int index = selectMinIndex();
			visited[index] = true;

			for (int j = 0; j < N; j++) {
				if (!visited[j]) {
					// 기존 알고 있던 j 도시까지 비용 vs 새로 선택한 도시를 거쳐 가는 비용
					dijkstra[j] = Math.min(dijkstra[j], dijkstra[index] + map[index][j]);
				}
			}
		}

		System.out.println(dijkstra[to]);
	}

	private static int selectMinIndex() {
		int minIndex = 0;
		long min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			if (min > dijkstra[i]) {
				min = dijkstra[i];
				minIndex = i;
			}
		}

		return minIndex;
	}
}
