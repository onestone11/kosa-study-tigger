def solution(n):
    answer = []
    a = [[0] * n for i in range(n)]
    x , y = -1, 0
    num = 1

    for i in range(n):
        # 0, 1, 2, 3
        for _ in range(i, n):
            if i % 3 == 0:
                x += 1
            elif i % 3 == 1:
                y += 1
            else:
                x -= 1
                y -= 1
            a[x][y] = num
            num+=1

    for i in range(n):
        for j in range(i+1):
            answer.append(a[i][j])
    return answer
