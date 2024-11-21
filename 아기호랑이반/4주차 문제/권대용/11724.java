import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] graph; // 그래프를 인접 리스트로 표현
    static boolean[] visited;          // 방문 여부 체크
    static int connectedComponents;    // 연결 요소의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정점과 간선의 개수 입력
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v); // 양방향 간선
            graph[v].add(u);
        }

        // 방문 배열 초기화
        visited = new boolean[n + 1];
        connectedComponents = 0;

        // 모든 정점을 순회하며 DFS 호출
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 방문하지 않은 정점이면 새로운 연결 요소 시작
                dfs(i);
                connectedComponents++; // 연결 요소 개수 증가
            }
        }

        // 결과 출력
        System.out.println(connectedComponents);
    }

    // DFS 구현
    public static void dfs(int node) {
        visited[node] = true; // 현재 노드 방문 처리

        // 현재 노드와 연결된 모든 노드 탐색
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) { // 방문하지 않은 노드만 탐색
                dfs(neighbor);
            }
        }
    }
}
