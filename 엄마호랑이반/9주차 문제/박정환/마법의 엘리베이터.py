def solution(storey):
    answer = 0
    while storey > 0:
        l = storey % 10
        print("l: ", l)
        if l > 5:
            answer += (10 - l)
            storey += 10
        elif l < 5:
            answer += l
        
        else:
            if (storey // 10) % 10 > 4:
                storey += 10
            answer += 5
        storey //= 10
    return answer
