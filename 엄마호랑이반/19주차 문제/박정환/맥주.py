from collections import deque

T = int(input())

def BFS():
    Q = deque()
    Q.append((s_x, s_y))
    while Q:
        x, y = Q.popleft()
        if abs(x - f_x) + abs(y - f_y) <= 1000:
            print('happy')
            return
        for i in range(n):
            if visited[i] == 0:
                p_x, p_y = s[i]
                if abs(x - p_x) + abs(y - p_y) <= 1000:
                    visited[i] = 1
                    Q.append((p_x, p_y))
    print('sad')
    return



for _ in range(T):
    n = int(input())
    s_x, s_y = map(int, input().split())
    s = [list(map(int, input().split())) for _ in range(n)]
    f_x, f_y = map(int, input().split())
    visited = [0 for _ in range(n+1)]
    BFS()
