import java.util.ArrayList;

class Solution {
    private boolean[] visited;
    private ArrayList<Integer>[] graph;
    private int N;
    private int answer;
    public int solution(int n, int[][] wires) {
        N = n;
        answer = n;
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        visited = new boolean[n + 1];
        dfs(1);
        return answer;
    }
    
    private int dfs(int node) {
        visited[node] = true;
        int subtree = 1;
    
        for (int next : graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                int childCnt = dfs(next);
                
                answer = Math.min(answer, Math.abs(N - 2 * childCnt));
                subtree += childCnt;
            }
        }
        
        return subtree;
    }
}
