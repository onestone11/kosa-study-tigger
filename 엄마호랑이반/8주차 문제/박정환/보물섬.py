from collections import deque

n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]

# print(board)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0 , -1]

def bfs(i,j):
  q = deque()
  q.append((i,j))
  visited[i][j]=1
  cnt=0
  while q:
    x, y = q.popleft()
    for i in range(4):
      xx = x+dx[i]
      yy = y+dy[i]
      if 0<= xx < n and 0<= yy < m and board[xx][yy]=='L' and visited[xx][yy]==0:
        visited[xx][yy]=visited[x][y]+1
        cnt = max(cnt, visited[xx][yy])
        q.append((xx,yy))
  return cnt-1

result=0
for i in range(n):
  for j in range(m):
    visited = [[0]*m for _ in range(n)]
    if board[i][j] == 'L':
      result = max(result, bfs(i,j))

print(result)
