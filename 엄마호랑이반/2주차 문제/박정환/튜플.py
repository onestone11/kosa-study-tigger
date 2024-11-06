def solution(s):
    a = []
    for i in (s.split('},')):
        a.append(i.replace('{', '').replace('}', '').split(','))
    a.sort(key=len)
    answer = []
    for i in a:
        for j in i:
            if j not in answer:
                answer.append(j)
    print(answer)
    return list(map(int, answer))

print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))

