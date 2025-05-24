import java.util.*;

class Solution {   
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] dist = bfs(n, graph);
        
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) answer++;
        }
        
        return answer;
    }
    
    private int[] bfs(int n, List<Integer>[] graph) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        visited[1] = true;
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        return dist;
    }
}
