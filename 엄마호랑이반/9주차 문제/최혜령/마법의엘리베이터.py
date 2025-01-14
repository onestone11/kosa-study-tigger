def solution(storey):
    answer = 0
    storey = abs(storey) # 절댓값으로 변환 (양수만 계산)
    while storey:
        print(f"current storey:{storey} answer:{answer}")
        div=storey%10
        if (div==5 and storey//10%10>=5) or div>5:
            storey+=10-div
            answer+=10-div
        else:
            answer+=div
        storey=storey//10
        print(f"end storey:{storey} answer:{answer}")
        
    return answer
