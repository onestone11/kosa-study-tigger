def solution(land):
    n, m = len(land), len(land[0])
    
    # 각 열의 석유량을 저장할 배열
    column_oil = [0] * m
    
    # 방문 체크를 위한 배열
    visited = [[False] * m for _ in range(n)]
    
    # BFS로 석유 그룹 크기와 속한 열 찾기
    def bfs(x, y):
        # 그룹에 포함된 열을 저장할 집합
        columns = set([y])
        # 그룹의 크기
        size = 0
        
        queue = [(x, y)]
        visited[x][y] = True
        
        while queue:
            cx, cy = queue.pop(0)
            size += 1
            
            # 4방향 탐색
            for dx, dy in [(1,0), (-1,0), (0,1), (0,-1)]:
                nx, ny = cx + dx, cy + dy
                # 범위 체크, 석유 존재 체크, 방문 여부 체크
                if (0 <= nx < n and 0 <= ny < m and 
                    land[nx][ny] == 1 and not visited[nx][ny]):
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    columns.add(ny)
        
        return size, columns
    
    # 모든 석유 그룹 탐색
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visited[i][j]:
                group_size, group_columns = bfs(i, j)
                
                # 그룹의 각 열에 석유량 누적
                for col in group_columns:
                    column_oil[col] += group_size
    
    # 최대 석유량 반환
    return max(column_oil)
