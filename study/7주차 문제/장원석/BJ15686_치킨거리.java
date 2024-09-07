import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15686_치킨거리 {

	static int N, M, answer;
	static int[][] city;
	static List<int[]> home;
	static List<int[]> chicken;
	static boolean[] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		city = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				city[i][j] = k;

				if (k == 1)
					home.add(new int[] { i, j });
				else if (k == 2)
					chicken.add(new int[] { i, j });
			}
		}

		answer = Integer.MAX_VALUE;
		checked = new boolean[chicken.size()];

		dfs(0, 0);

		System.out.println(answer);
	}

	private static void dfs(int index, int depth) {
		
		// M만큼 dfs 연산이 끝났을 때, 모든 집과 치킨집 사이의 치킨 거리를 구한다.
		if (depth == M) {
			int sum = 0;

			for (int[] h : home) {
				int min = Integer.MAX_VALUE;

				for (int j = 0; j < chicken.size(); j++) {
					if (checked[j]) {
						int d = Math.abs(h[0] - chicken.get(j)[0]) + Math.abs(h[1] - chicken.get(j)[1]);
						min = Math.min(min, d);
					}
				}

				sum += min;
			}

			answer = Math.min(answer, sum);

			return;
		}

		for (int i = index; i < chicken.size(); i++) {
			checked[i] = true;
			dfs(i + 1, depth + 1);
			checked[i] = false;
		}
	}
}
