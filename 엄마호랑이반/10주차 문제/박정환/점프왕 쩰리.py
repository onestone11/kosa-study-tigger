n = int(input())

board = [list(map(int, input().split())) for _ in range(n)]

ch = [[0]* n for _ in range(n)]

dx = [1, 0]
dy =  [0, 1]

def DFS(x, y):
    ch[x][y] = 1
    for i in range(2):
        xx = x + dx[i]*board[x][y]
        yy = y + dy[i]*board[x][y]
        if 0<=xx<n and 0<=yy<n and ch[xx][yy] ==0:
            if board[xx][yy] == -1:
                print("HaruHaru")
                exit(0)
            else:
                DFS(xx,yy)
    return "Hing"
print(DFS(0, 0))

