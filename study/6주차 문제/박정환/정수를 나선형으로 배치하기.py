def solution(n):
    answer = [[0] * n for _ in range(n)]
    x, y = 0, 0
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    x2 = 2
    answer[x][y] = 1
    while x2 <= n**2:
        for i in range(len(dx)):
            while True:
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or ny < 0 or nx >= n or ny >= n or answer[nx][ny] != 0:
                    break
                else:
                    answer[nx][ny] = x2
                    x = nx
                    y = ny
                    x2 += 1
    return answer
