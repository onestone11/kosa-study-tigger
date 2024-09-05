from collections import deque

def slide(start, direction, board):
    x, y = start
    rows, cols = len(board), len(board[0])
    dx, dy = direction
    
    while True:
        nx, ny = x + dx, y + dy
        if 0 <= nx < rows and 0 <= ny < cols and board[nx][ny] != 'D':
            x, y = nx, ny
            
        else:
            break
            
    if board[x][y] == 'G':
        return (x, y), True
    
    return (x, y), False

def bfs(start, board):
    rows, cols = len(board), len(board[0])
    directions = [(0, -1), (0, 1), (-1, 0), (1, 0)]  # 왼쪽, 오른쪽, 위, 아래
    queue = deque([(start[0], start[1], 0)])  # (x, y, steps)
    visited = set()
    visited.add(start)
    
    while queue:
        x, y, steps = queue.popleft()
        
        for direction in directions:
            (nx, ny), isarrived = slide((x, y), direction, board)
            
            if isarrived:
                return steps + 1
            
            if (nx, ny) not in visited:
                visited.add((nx, ny))
                queue.append((nx, ny, steps + 1))
    
    return -1  # 도달할 수 없는 경우
    
def solution(board):
    answer = 0
    currentX, currentY = -1, -1
    goalX, goalY = -1, -1
    for i in range (len(board)):
        for j in range (len(board[i])):
            if board[i][j] == 'R':
                currentX, currentY = i, j
    
    return bfs((currentX, currentY), board)
         
