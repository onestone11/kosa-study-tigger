# 아래는 본인 코드임 (시중아님, 자꾸 시간초과떠서 빡쳐서 시중답안 넣어봤는데 자꾸 시간초과뜸 ㅠㅠ)
import sys

# 입력 처리
r, c = map(int, input().split())
board = [sys.stdin.readline().rstrip() for _ in range(r)]

# 방향 설정 (우, 좌, 하, 상)
directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
visited = [False for _ in range(26)]
x, y, depth = 0, 0, 1
def dfs(x, y, depth):
    global answer
    answer = max(answer, depth)
    
    visited[ord(board[x][y])-65] = True

    for direction in directions:
        nx = x + direction[0]
        ny = y + direction[1]
        if 0 <= nx < r and 0 <= ny < c:
            if visited[ord(board[nx][ny])-65] == False:

                dfs(nx, ny, depth + 1)
                visited[ord(board[nx][ny])-65] = False

# 실행 및 출력
global answer
answer = 0

dfs(x, y, depth)
print(answer)
