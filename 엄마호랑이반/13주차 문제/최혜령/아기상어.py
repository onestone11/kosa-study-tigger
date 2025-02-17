import sys
from collections import deque

# 입력 처리
input = sys.stdin.readline
n = int(input())
matrix = []
shark_size = 2  # 초기 상어 크기
fish_count = 0  # 전체 물고기 수
px, py = -1, -1  # 아기 상어 위치

# 맵 정보 입력 및 상어 위치 찾기
for i in range(n):
    line = list(map(int, input().split()))
    for j in range(n):
        if line[j] == 9:
            px, py = i, j  # 아기 상어 위치 저장
            line[j] = 0  # 상어가 있던 자리 빈칸으로 처리
        elif 1 <= line[j] <= 6:
            fish_count += 1  # 물고기 개수 증가
    matrix.append(line)

# 네 방향 탐색 (위, 왼쪽, 오른쪽, 아래 순)
directions = [(-1, 0), (0, -1), (0, 1), (1, 0)]

# BFS 탐색 함수 (가장 가까운 물고기 찾기)
def bfs():
    queue = deque([(px, py, 0)])  # (x, y, 이동 거리)
    visited = set([(px, py)])
    fish_list = []  # 먹을 수 있는 물고기 후보

    while queue:
        x, y, dist = queue.popleft()

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if 0 <= nx < n and 0 <= ny < n and (nx, ny) not in visited:
                if matrix[nx][ny] <= shark_size:  # 지나갈 수 있는지 확인
                    queue.append((nx, ny, dist + 1))
                    visited.add((nx, ny))

                    if 1 <= matrix[nx][ny] < shark_size:  # 먹을 수 있는 물고기
                        fish_list.append((dist + 1, nx, ny))

    # 정렬 (거리, 행, 열 순)
    fish_list.sort()
    return fish_list[0] if fish_list else None

# 시뮬레이션 실행
time = 0
eat_count = 0  # 먹은 물고기 수

while True:
    fish = bfs()
    if not fish:  # 먹을 물고기가 없다면 종료
        break

    dist, nx, ny = fish  # 가장 가까운 물고기 선택
    time += dist  # 이동 시간 추가
    matrix[nx][ny] = 0  # 물고기 먹기
    px, py = nx, ny  # 상어 이동
    eat_count += 1  # 먹은 개수 증가

    if eat_count == shark_size:  # 상어 크기 증가 조건 충족
        shark_size += 1
        eat_count = 0

# 결과 출력
print(time)
