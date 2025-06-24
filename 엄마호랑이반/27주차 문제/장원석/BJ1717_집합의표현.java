import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			parents[i] = i;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int cal = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (cal == 0) {
				union(a, b);
			} else {
				int findA = find(a);
				int findB = find(b);

				if (findA == findB)
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		parents[parentA] = parentB;

	}

	private static int find(int n) {
		if (n != parents[n])
			parents[n] = find(parents[n]);

		return parents[n];
	}
}
