dx = [1, 0]
dy = [0, 1]

def DFS(x, y, c):
    global min_re, max_re
    if x == n-1 and y == n-1:
        max_re = max(max_re, c)
        min_re = min(min_re, c)
        return
    
    for i in range(2):
        xx = x + dx[i]
        yy = y + dy[i]
        if xx == n or yy == n:
            continue
        if board[x][y] == '*':
            DFS(xx, yy , c * board[xx][yy])
        elif board[x][y] == '+':
            DFS(xx, yy , c + board[xx][yy])
        elif board[x][y] == '-':
            DFS(xx, yy , c - board[xx][yy])
        else: # 현재 값이 연산자, 연산 저장
            DFS(xx, yy, c)

n = int(input())

board = [list(input().split()) for _ in range(n)]

max_re = -2147000000 
min_re = 2147000000
for i in range(n):
    for j in range(n):
        if (i + j) % 2 == 0:
            board[i][j] = int(board[i][j])

DFS(0, 0, board[0][0])
print(max_re, min_re)
