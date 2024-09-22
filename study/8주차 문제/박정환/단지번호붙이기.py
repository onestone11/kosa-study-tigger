dx = [-1, 0, 1, 0] # 좌, 하, 우, 상
dy = [0, -1, 0, 1]

def DFS(x, y):
    global cnt
    cnt += 1
    a[x][y] = 0
    for i in range(4):
        xx = x + dx[i]
        yy = y + dy[i]
        if 0<= xx < n and 0 <= yy < n and a[xx][yy] == 1:
            DFS(xx, yy)

n = int(input())
a = [list(map(int, input())) for _ in range(n)] # split() 안함
answer = []
for i in range(n):
    for j in range(n):
        if a[i][j] == 1:
            cnt = 0
            DFS(i, j)
            answer.append(cnt)
print(len(answer))
answer.sort()
for i in answer:
    print(i)
