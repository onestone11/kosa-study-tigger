def solution(players, m, k):
    answer = 0
    server = [0] * len(players)

    for i in range(24):

        if (players[i] // m) > server[i]:
            tmp = (players[i] // m) - server[i]
            answer+= tmp
            if i + k < 24:
                for j in range(i, i + k):
                    server[j] += tmp
            else:
                for j in range(i, 24):
                    server[j] += tmp

    return answer


print(solution([0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5], 3, 5))
