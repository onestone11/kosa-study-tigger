from collections import Counter
def solution(weights):
    answer = 0
    a = Counter(weights)
    # {100: 2, 180: 1, 360: 1, 270: 1}
    for w, c in a.items():
        if c >=2:
            answer += c *(c-1)//2
        
    s = set(weights)

    for i in s:
        if i * (2/3) in s:
            answer += a[i *(2/3)] * a[i]
        if i * (2/4) in s:
            answer += a[i *(2/4)]* a[i]
        if i * (3/4) in s:
            answer += a[i *(3/4)]* a[i]

    return answer 

solution([100,180,360,100,270])
