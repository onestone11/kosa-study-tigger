import java.util.*;

class Solution {
    static int answer;
    static List<Integer>[] graph;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;

        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            graph[parent].add(child);
        }
        
        answer = 0;
        List<Integer> next = new ArrayList<>();
        next.add(0);
        
        dfs(0, 0, 0, next, info);
        return answer;
    }
    
    private void dfs(int idx, int sheep, int wolf, List<Integer> next, int[] info) {
        if (info[idx] == 1) wolf++;
        else sheep++;
        
        if (sheep <= wolf) return;
        
        answer = Math.max(answer, sheep);
        
        List<Integer> candidates = new ArrayList<>(next);
        candidates.remove(Integer.valueOf(idx));
        candidates.addAll(graph[idx]);
        
        for (int child : candidates) {
            dfs(child, sheep, wolf, candidates, info);
        }
    }
}
