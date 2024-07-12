package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1260
 * 실버2 DFS와 BFS
 */

public class BJ1260_DFS와BFS {

	static int N, M, V;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visit;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		visit = new boolean[N + 1];
		sb = new StringBuilder();
		dfs(V);

		visit = new boolean[N + 1];
		sb.append("\n");
		bfs(V);
		
		System.out.println(sb.toString());
	}

	private static void dfs(int node) {
		visit[node] = true;
		sb.append(node).append(" ");
		
		for (int number : graph.get(node)) {
			if(!visit[number]) {
				dfs(number);
			}
		}
	}

	private static void bfs(int node) {
		visit[node] = true;
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int target = queue.poll();
			sb.append(target).append(" ");
			
			for (int number : graph.get(target)) {
				if(!visit[number]) {
					visit[number] = true;
					queue.add(number);
				}
			}
		}
	}

}
