#include <stdio.h>
#include <stdbool.h>

#define MAX 1001

int arr[MAX][MAX]; // 방향 없는 그래프 배열
bool visited[MAX]; // 방문 여부 기록
int N, M;          // 정점의 개수 N, 간선의 개수 M

// 깊이 우선 탐색 (DFS) 함수
void DFS(int node)
{
    visited[node] = true; // 현재 정점 방문 기록
    for (int i = 1; i <= N; i++)
    {
        // 현재 정점(node)과 연결되어 있고, 아직 방문하지 않은 정점(i)을 탐색
        if (arr[node][i] == 1 && !visited[i])
            DFS(i);
    }
}

int main(void)
{
    scanf("%d %d", &N, &M); // 정점 개수 N, 간선 개수 M

    for (int i = 0; i < M; i++)
    {
        int a, b;
        scanf("%d %d", &a, &b);
        arr[a][b] = 1; // a에서 b로 가는 간선 추가
        arr[b][a] = 1; // 방향 없는 그래프이므로 b에서 a로 가는 간선 추가
    }

    int count = 0; // 연결 요소 개수 변수

    // 모든 정점을 순회하며 방문하지 않은 정점을 찾음
    for (int i = 1; i <= N; i++)
    {
        // 방문하지 않은 정점이라면 DFS 수행 후 연결 요소 개수 증가
        if (!visited[i])
        {
            DFS(i);
            count++;
        }
    }

    printf("%d\n", count);

    return 0;
}
