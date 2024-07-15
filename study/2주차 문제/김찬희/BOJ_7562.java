import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class BOJ_7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // ⭐️ 체스 말이 이동할 수 있는 방향은 8가지 ⭐️
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        for(int i=0; i<n; i++) {
            int size = Integer.parseInt(br.readLine());
            boolean[][] isVisited = new boolean[size][size];
            int[][] count = new int[size][size];
            String[] startPoint = br.readLine().split(" ");
            String[] endPoint = br.readLine().split(" ");
            Queue<Integer> queueX = new LinkedList<>();
            Queue<Integer> queueY = new LinkedList<>();

            // 시작점
            int startX = Integer.parseInt(startPoint[0]);
            int startY = Integer.parseInt(startPoint[1]);

            queueX.add(startX);
            queueY.add(startY);
            isVisited[startX][startY] = true;

            while(!queueX.isEmpty()) {
                int x = queueX.poll();
                int y = queueY.poll();

                // 목적지에 도달했는지
                if(x == Integer.parseInt(endPoint[0]) && y == Integer.parseInt(endPoint[1])) break;

                for(int j=0; j<dx.length; j++) {
                    int cx = x + dx[j];
                    int cy = y + dy[j];

                    // step 1) 범위 비교
                    if(cx<0 || cx>=size || cy<0 || cy>=size) continue;
                    
                    // step 2) 방문 기록 확인
                    if(!isVisited[cx][cy]) {
                        queueX.add(cx);
                        queueY.add(cy);
                        count[cx][cy] = count[x][y] + 1;
                        isVisited[cx][cy] = true;
                    }
                }
            }
            System.out.println(count[Integer.parseInt(endPoint[0])][Integer.parseInt(endPoint[1])]);
        }
    }
}