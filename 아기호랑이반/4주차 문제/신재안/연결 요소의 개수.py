import sys
sys.setrecursionlimit(10**4)
input = sys.stdin.readline

def DFS(node):
    if visited[node]:
        return
    visited[node] = True
    for adjNode in adjList[node]:
        if not visited[adjNode]:
            DFS(adjNode)

n, m = map(int, input().split())
visited = [False] * (n + 1)
adjList = [[] for _ in range(n+1)]
count = 0

for i in range(m):
    node1, node2 = map(int, input().split())
    adjList[node1].append(node2)
    adjList[node2].append(node1)

for i in range(1, n+1):
    if not visited[i]:
        count += 1
        DFS(i)

print(count)
