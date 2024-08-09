from collections import deque
import sys

data = sys.stdin.readline().rstrip().split()
m, n = int(data[0]), int(data[1])

box = []
queue = deque()

for i in range(n):
    line = list(map(int, sys.stdin.readline().rstrip().split()))
    box.append(line)
    for j in range(m):
        if line[j] == 1:
            queue.append((i, j))

# 모든 토마토가 익어있는 상태이면 0을 출력
if len(queue) == n * m:
    print(0)
    exit()

# 방향 벡터 정의 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

days = 0

while queue:
    days += 1
    for _ in range(len(queue)):
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and box[nx][ny] == 0:
                box[nx][ny] = 1
                queue.append((nx, ny))

# 익지 않은 토마토가 있는지 확인
for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            print(-1)
            exit()

print(days - 1)
