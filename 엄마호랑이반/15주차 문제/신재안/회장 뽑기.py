import sys

m = int(input())
INF = float('inf')
graph = [[INF for _ in range(m + 1)] for _ in range(m + 1)]

for i in range(1, m + 1):
    graph[i][i] = 0

while True:
    a, b = map(int, sys.stdin.readline().split())
    if a == -1 and b == -1:
        break
    graph[a][b] = 1
    graph[b][a] = 1

for i in range(1, m + 1):
    for j in range(1, m + 1):
        for k in range(1, m + 1):
            graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k])

scores = []
for i in range(1, m + 1):
    maxDist = 0
    for j in range(1, m + 1):
        maxDist = max(maxDist, graph[i][j])
    scores.append(maxDist)

candidateScore = min(scores)
candidate = [i + 1 for i, score in enumerate(scores) if score == candidateScore]

print(candidateScore, len(candidate))
print(*candidate)
