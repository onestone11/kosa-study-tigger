from collections import deque

n, m = map(int, input().split())

a = [list(input()) for _ in range(m)]
visited = [[0] * n for _ in range(m)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def BFS(x, y, c):
    Q = deque()
    Q.append((x, y))
    visited[x][y] = 1
    cnt = 0
    while Q:
        x,y = Q.popleft()
        cnt += 1
        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]
            if 0 <= xx < m and 0 <= yy < n and a[xx][yy] == c and visited[xx][yy] == 0:
                Q.append((xx, yy))
                visited[xx][yy] = 1
    return cnt

w_cnt = 0
b_cnt = 0

for i in range(m):
    for j in range(n):
        if visited[i][j] == 0:
            if a[i][j] == 'W':
                w_cnt += BFS(i, j, 'W') ** 2
            elif a[i][j] == 'B':
                b_cnt += BFS(i, j, 'B') ** 2

print(w_cnt, b_cnt)
