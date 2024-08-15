def solution(n):
    answer = [[0] * n for _ in range(n)]
    row = 0
    col = 0
    dr = [0, 1, 0, -1]
    dc = [1, 0, -1, 0]
    d = 0
    cnt = 1
    
    while(cnt <= n*n):
        answer[row][col] = cnt
        cnt += 1
        
        if row + dr[d] < 0 or row + dr[d] == n or col + dc[d] < 0 or col + dc[d] == n:
            d += 1
        elif answer[row+dr[d]][col+dc[d]] != 0:
            d +=1
            
        if d > 3:
            d = 0
            
        row += dr[d]
        col += dc[d]
        
    return answer
