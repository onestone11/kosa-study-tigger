def solution(strings, n):
    answer = []  
    strings.sort()               
    a = []          
    
    for i in strings:
        a.append(i[n])
    a.sort()        
    
    for i in a:
        for j in strings:
            if i == j[n]:    
                answer.append(j)
                strings.remove(j)
                break              
            
    return answer
