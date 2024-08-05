player = [list(map(int, input().split())) for _ in range(5)]
mc = [list(map(int, input().split())) for _ in range(5)]

def count_bingo(ls):
    bingo = 0
    # 가로 세기
    i = 0
    for line in ls:
        if sum(line) == 0:
            bingo += 1

    j = 0
    # 세로 세기
    while j < 5:
        i = 0
        tmp = 0
        while i < 5:
            if ls[i][j] == 0:
                tmp += 1
            i += 1
        if tmp == 5:
            bingo += 1
        j += 1

            
    # 대각선 세기
    if ls[0][0] == 0 and ls[1][1] == 0 and ls[2][2] == 0 and ls[3][3] == 0 and ls[4][4] == 0:
        bingo += 1
    
    if ls[0][4] == 0 and ls[1][3] == 0 and ls[2][2] == 0 and ls[3][1] == 0 and ls[4][0] == 0:
        bingo += 1

    return bingo

answer = 0

for a in range(0,5):
    for b in range(0,5):
        for c in range(0,5):
            for d in range(0,5):
                if player[c][d] == mc[a][b]:
                    player[c][d] = 0
        answer += 1 
        if answer >= 12:
            bingo = count_bingo(player)
            if bingo >= 3:
                print(answer)
                exit()
         
