import sys
from collections import deque

n = int(input())
values = []

for _ in range(n):
    line = input().split()
    values.append([int(x) for x in line])

def bfs(values):
    n = len(values)
    visited = [[False] * n for _ in range(n)]
    queue = deque([(0, 0)])  # Start position
    visited[0][0] = True
    
    while queue:
        x, y = queue.popleft()
        jump = values[x][y]
        
        if jump == -1:  # 도착점 도달
            return True
            
        # 오른쪽 이동
        new_y = y + jump
        if new_y < n and not visited[x][new_y]:
            visited[x][new_y] = True
            queue.append((x, new_y))
            
        # 아래로 이동
        new_x = x + jump
        if new_x < n and not visited[new_x][y]:
            visited[new_x][y] = True
            queue.append((new_x, y))
            
    return False

result = bfs(values)
print("HaruHaru" if result else "Hing")
