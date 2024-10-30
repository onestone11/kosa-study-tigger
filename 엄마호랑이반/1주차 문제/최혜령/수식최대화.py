from itertools import permutations

def solution(expression):
    exp = set()
    exps = []
    num = ""
    for i in range(len(expression)):
        try:
            isNum = int(expression[i])
            num += expression[i]
        except Exception:
            exp.add(expression[i])
            exps.append(int(num))
            exps.append(expression[i])
            num = ""
    exps.append(int(num))
    
    combs = permutations(exp)
    answer = 0
    
    for comb in combs:
        tmp = exps.copy()
        for c in comb:
            indexes = []
            i = 0
            while i < len(tmp):
                if tmp[i] == c:
                    left, right = tmp[i-1], tmp[i+1]
                    result = 0
                    if c == "*":
                        result = left * right
                    elif c == "+":
                        result = left + right
                    else:
                        result = left - right
                    tmp[i-1] = result
                    tmp.pop(i)
                    tmp.pop(i)
                    i -= 1
                i += 1
            
        if abs(tmp[0]) > answer:
            answer = abs(tmp[0])
    
    
    return answer
