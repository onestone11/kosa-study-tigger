def solution(m, n, puddles):
    board = [[0] * (m + 1) for _ in range(n+1)]
    board[1][1] = 1

    for y, x in puddles:
        board[x][y] = -1
    
    # print(board)

    for i in range(1, n+1):
        for j in range(1, m+1):
            if i == 1 and j == 1:
                continue
            if board[i][j] == -1:
                board[i][j] = 0
            else:
                board[i][j] = board[i][j-1] + board[i-1][j]
    return board[n][m] % 1000000007


print(solution(4, 3, [[2,2]]))
