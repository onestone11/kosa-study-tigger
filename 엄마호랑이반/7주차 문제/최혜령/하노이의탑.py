def solution(n):
    def hanoi(start, target, temp, N):
        # print([[start, target]])
        if N == 1:
            return [[start, target]]
        return hanoi(start, temp, target, N-1) + [[start, target]] + hanoi(temp, target, start, N-1)

    return hanoi(1, 3, 2, n)
