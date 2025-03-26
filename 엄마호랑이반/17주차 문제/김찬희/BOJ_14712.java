import java.util.Scanner;

public class Main {
    static int n, m;
    static int answer = 0;
    static boolean[][] isVisited;

    public static void dfs(int depth) {
        // 가능한 배치 방법 하나를 찾았으므로 경우의 수 증가
        if (depth == n * m) {
            answer++;
            return;
        }
    
        // 몫 + 1 = x 좌표
        // 나머지 + 1 = y 좌표
        int x = depth / m + 1;
        int y = depth % m + 1;
    
        // 왼쪽 위, 왼쪽, 위 칸에 모두 넴모가 있는지 확인
        if (isVisited[x-1][y] && isVisited[x][y-1] && isVisited[x-1][y-1]) {
            // 넴모를 놓지 않고 다음 칸으로 진행
            dfs(depth + 1);
        } else {
            // 넴모를 놓지 않고 다음 칸으로 진행
            dfs(depth + 1);     
    
            isVisited[x][y] = true;
            dfs(depth + 1);
    
            isVisited[x][y] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        isVisited = new boolean[n+1][m+1];

        dfs(0);
        System.out.println(answer);
    }
}
