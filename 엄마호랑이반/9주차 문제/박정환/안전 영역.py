import sys

dx = [-1, 0, 1, 0]
dy = [0, 1, 0 , -1]
sys.setrecursionlimit(10**6)

def DFS(x, y, h):
    ch[x][y] = 1
    for k in range(4):
        xx = x + dx[k]
        yy = y + dy[k]
        if 0<= xx <n  and 0<=yy<n and board[xx][yy]>h and ch[xx][yy] == 0:
            DFS(xx, yy, h)

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

res = 0
for h in range(100):
    cnt = 0
    ch = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if board[i][j] > h and ch[i][j] == 0:
                cnt += 1
                DFS(i, j, h)
    res = max(res, cnt)

print(res)
