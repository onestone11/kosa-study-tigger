def solution(n):
    # 2D 리스트 초기화
    matrix = [[0] * n for _ in range(n)]
    
    # 방향 벡터: 아래 -> 오른쪽 -> 왼쪽 위
    directions = [(1, 0), (0, 1), (-1, -1)]
    x, y, num = 0, 0, 1  # 시작 위치와 숫자
    direction_idx = 0    # 방향 인덱스
    
    for _ in range(n * (n + 1) // 2):  # n번째 삼각형까지 채우기
        matrix[x][y] = num  # 현재 위치 채우기
        num += 1
        
        # 다음 위치 계산
        dx, dy = directions[direction_idx]
        nx, ny = x + dx, y + dy
        
        # 다음 위치가 범위를 벗어나거나 이미 채워진 경우 방향 변경
        if nx < 0 or ny < 0 or nx >= n or ny >= len(matrix[nx]) or matrix[nx][ny] != 0:
            direction_idx = (direction_idx + 1) % 3  # 방향 전환
            dx, dy = directions[direction_idx]
            nx, ny = x + dx, y + dy
        
        # 다음 위치로 이동
        x, y = nx, ny
    
    # 결과를 1D 리스트로 반환
    result = []
    for row in matrix:
        result.extend(row[:row.index(0)] if 0 in row else row)
    
    return result
