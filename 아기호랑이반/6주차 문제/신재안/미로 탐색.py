def bfs(x, y):
    queue = [(x, y)]
  
    while queue:
        x, y = queue.pop(0)
      
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
          
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
              
            if graph[nx][ny] == 0:
                continue
              
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
              
    print(graph[n-1][m-1])

n, m = map(int, input().split(' '))
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
graph = [list(map(int, input().strip())) for _ in range(n)]

bfs(0, 0)
