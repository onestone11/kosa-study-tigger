def solution(array, commands):
    answer = []
    for elem in commands:
        i, j, k = elem
        answer.append(sorted(array[i-1:j])[k-1])
    return answer
