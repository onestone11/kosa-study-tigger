from collections import deque

n, m = map(int, input().split())

before = [list(map(int, input().split())) for _ in range(n)]
after = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def BFS(x, y, after):
    Q = deque()
    Q.append((x, y))
    visited[x][y] = 1
    before_v = before[x][y] # 백신 전의 값
    while Q:
        x,y = Q.popleft()
        before[x][y] = after # 백신 전의 보드에서 후의 값으로 변경
        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]
            if 0 <= xx < n and 0 <= yy < m and visited[xx][yy] == 0:
                if before[xx][yy] == before_v:
                    Q.append((xx, yy))
                    visited[xx][yy] = 1
flag = True

for i in range(n):
    for j in range(m):
        if visited[i][j] == 0 and after[i][j] != before[i][j] and flag:
            flag = False
            BFS(i, j, after[i][j])


if flag:
    print('YES')
else:
    for i in range(n):
        for j in range(m):
            if before[i][j] != after[i][j]:
                print("NO")
                exit(0)

    print("YES")
