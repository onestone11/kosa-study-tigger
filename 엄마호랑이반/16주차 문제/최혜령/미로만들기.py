from collections import deque
import sys
n = int(sys.stdin.readline())
inputs = []
for _ in range(n):
    usr = str(sys.stdin.readline().rstrip())
    inputs.append(usr)

def bfs(n, inputs):
    queue = deque() # 시작점
    queue.append((0,0))
    visited = [[-1 for _ in range(n)] for _ in range(n)]
    visited[0][0] = 0
    # 사방 경로
    d = [(0, 1), (1, 0), (-1, 0), (0, -1)]
    while queue:
        x, y = queue.popleft()
        # 도착점 확인
        if x == n-1 and y == n-1:
            return visited[x][y]
        # 4방 탐색
        for i in range(4):
            dx, dy = d[i]
            cx, cy = x+dx, y+dy
            if 0<=cx<n and 0<=cy<n:
                if visited[cx][cy] == -1:
                    if int(inputs[cx][cy]) == 1: # 흰방
                        queue.appendleft((cx,cy))
                        visited[cx][cy] = visited[x][y] # 방문은 했으니, 문부순 횟수를 현재그대로 
                    else:
                        queue.append((cx, cy)) 
                        visited[cx][cy] = visited[x][y] + 1 # 문 부순 횟수를 1 증가 (검은방이니)
                    

print(bfs(n, inputs))
