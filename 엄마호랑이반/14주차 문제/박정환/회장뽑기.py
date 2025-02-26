from collections import deque

def BFS(i):
    visited = [-1] * (N+1)
    visited[i] = 0
    q = deque([i])
    while q:
        n = q.popleft()
        for i in l[n]:
            if visited[i] == -1:
                visited[i] = visited[n] + 1
                q.append(i)
    return max(visited)

N = int(input())
l = [[] for _ in range(N+1)]
while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break
    else:
        l[a].append(b)
        l[b].append(a)
# [[], [2], [1, 3, 4], [2, 4, 5], [3, 5, 2], [4, 3]]
min_val = 2147000000
answer = []
for i in range(1, N+1):
    val = BFS(i)
    if val < min_val:
        min_val = val
        answer = [i]
    elif val == min_val:
        answer.append(i)
print(min_val, len(answer))
print(*answer)
