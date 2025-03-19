import heapq

n = int(input())

rooms = [input().strip() for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

dist = [[float('inf') for _ in range(n)] for _ in range(n)]
dist[0][0] = 0

pq = [(0, 0, 0)]

while pq:
    cnt, x, y = heapq.heappop(pq)
    
    if x == n - 1 and y == n - 1:
        print(cnt)
        break

    if cnt > dist[x][y]:
        continue

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if n > nx >= 0 and n > ny >= 0:
            newCnt = cnt if rooms[nx][ny] == '1' else cnt + 1
        
            if newCnt < dist[nx][ny]:
                dist[nx][ny] = newCnt
                heapq.heappush(pq, (newCnt, nx, ny))
