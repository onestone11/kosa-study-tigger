def DFS(node):
    visited[node] = True
    for adjNode in adjList[node]:
        if not visited[adjNode]:
            DFS(adjNode)

computer = int(input())
pair = int(input())

visited = [False] * (computer + 1)

adjList = [[] for _ in range(computer + 1)]

firstInfected = 1

for _ in range(pair):
    node1, node2 = map(int, input().split())
    adjList[node1].append(node2)
    adjList[node2].append(node1)

DFS(firstInfected)
print(sum(visited) - 1)
