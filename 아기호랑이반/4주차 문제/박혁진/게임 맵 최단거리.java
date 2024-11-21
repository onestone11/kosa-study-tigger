import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; 
        int m = maps[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        

        queue.offer(new int[]{0, 0}); 
        visited[0][0] = true;
        
        int distance = 1; // 시작 위치도 포함
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // 현재 레벨의 모든 노드를 탐색
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                
                // 목표에 도착
                if (x == n - 1 && y == m - 1) {
                    return distance;
                }
                
                // 4방향 다 확인해보기
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    // 맵 범위 내에 있고, 방문하지 않았으며, 벽이 아닌 칸일 경우
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true; 
                    }
                }
            }
            
            distance++; // 거리 증가
        }
        
        // 상대 팀 진영에 도달할 수 없는 경우
        return -1;
    }
}
