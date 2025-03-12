import java.util.*;
import java.io.*;

public class Main {
	private static int n;
	private static int m;
	private static List<List<int[]>> root;
	private static int[] feed;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		root = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			root.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			root.get(a).add(new int[] {b, c});
			root.get(b).add(new int[] {a, c});
		}

		feed = new int[n+1];
		Arrays.fill(feed, Integer.MAX_VALUE);
		feed[0] = 0;
		dijkstra(1);

		System.out.println(feed[n]);
	}

	public static void dijkstra(int start) {
		Queue<int[]> heapq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		heapq.add(new int[] {start, 0});

		while (!heapq.isEmpty()) {
			int[] now = heapq.poll();
			int nowIdx = now[0];
			int nowCost = now[1];

			if (nowCost > feed[nowIdx]) continue;

			for(int[] next : root.get(nowIdx)) {
				int nextIdx = next[0];
				int nextCost = next[1] + nowCost;

				if (nextCost < feed[nextIdx]) {
					feed[nextIdx] = nextCost;
					heapq.add(new int[] {nextIdx, nextCost});
				}
			}
		}
	}
}
