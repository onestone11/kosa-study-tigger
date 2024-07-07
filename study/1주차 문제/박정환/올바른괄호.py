def solution(s):
    answer = True
    a = []
    
    for i in s:
        if i == '(':
            a.append('(')
        
        else:
            if len(a) == 0:
                return False
            else:
                a.pop()
                
    if len(a) != 0:
        return False
                
    return answer
