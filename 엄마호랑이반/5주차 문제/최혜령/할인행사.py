def solution(want, number, discount):
    answer = 0
    bucket = {}
    for i in range(len(want)):
        bucket[want[i]] = number[i]
    
    j = 0
    tmpbucket = bucket.copy()
    while j < len(discount):
        can = True
        for i in range(10):
            try:
                if tmpbucket[discount[i+j]] > 0:
                    tmpbucket[discount[i+j]] -= 1
                else:
                    can = False
            except Exception:
                can = False
        if can:
            answer += 1
        tmpbucket = bucket.copy()
        j += 1
    return answer
