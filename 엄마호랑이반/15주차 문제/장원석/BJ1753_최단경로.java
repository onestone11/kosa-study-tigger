import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753_최단경로 {

	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "( " + v + " " + w + " )";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		int[] dist = new int[V + 1];
		boolean[] visit = new boolean[V + 1];
		List<List<Node>> graph = new ArrayList<>();

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(u).add(new Node(v, w));
		}

//		int num = 0;
//		for (List<Node> list : graph) {
//			System.out.print(num + " : ");
//			System.out.println(list);
//			num++;
//		}

		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
			return Integer.compare(n1.w, n2.w);
		});

		dist[K] = 0;
		pq.add(new Node(K, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (!visit[now.v])
				visit[now.v] = true;

			for (Node node : graph.get(now.v)) {
				if (!visit[node.v]) {
					if (now.w + node.w < dist[node.v]) {
						dist[node.v] = now.w + node.w;
						pq.add(new Node(node.v, dist[node.v]));
					}
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}
}
