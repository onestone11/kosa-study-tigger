def solution(s):
    answer = []
    dic = {}
    strs = s[1:-1].split("}")
    dic = {}
    for elem in strs:
        if len(elem) > 0:
            if elem[0] == '{':
                e = elem[1:].split(",")
            else:
                e = elem[2:].split(",")
            
            dic[len(e)] = e
    dics = sorted(dic.items(), key=lambda x:x[0])
    for key, item in dics:
        for i in item:
            if int(i) not in answer:
                answer.append(int(i))
    
    return answer
