def solution(k, tangerine):
    answer = 0
    a={}
    for i in tangerine:
        if i in a:
            a[i]+=1
        else:
            a[i]=1
    a = dict(sorted(a.items(), key=lambda x: x[1], reverse=True))
    for i in a:
        if k<=0:
            return answer
        k-=a[i]
        answer+=1
    return answer
