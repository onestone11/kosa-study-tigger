def solution(s):
    answer = []
    for i in range(1,len(s)+1):
        line = ""
        tmp = s[:i]
        count = 1
        for j in range(i, len(s)+i, i):
            current = s[j:j+i]
            if tmp == current:
                count += 1
            else:
                if count > 1:
                    line += (str(count) + tmp)
                    
                else:
                    line += tmp
                
                tmp = current
                count = 1
                
        answer.append(len(line))
    return min(answer)
