def solution(files):
    answer = []
    dic = {}
    for file in files:
        head, number, tail = "", "", ""
        ishead, isnumber, istail = True, False, False
        
        for elem in file:
            if ishead == True and elem.isdigit() == False:
                head += elem
            elif ishead == True and elem.isdigit() == True:
                ishead = False
                isnumber = True
            if isnumber == True and elem.isdigit() == True:
                number += elem
            elif isnumber == True and elem == '.':
                isnumber = False
                istail = True
            if istail == True:
                tail += elem
        dic[file] = [head.lower(), int(number), tail]
    
    sorteddic = sorted(dic.items(), key=lambda x: (x[1][0], x[1][1]))
    answer = [elem[0] for elem in sorteddic]
    return answer
