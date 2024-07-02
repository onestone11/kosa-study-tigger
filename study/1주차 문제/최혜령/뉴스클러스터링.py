def solution(str1, str2):
    # 공백 String 2개 입력받았을 때
    if len(str1) == 0 and len(str2) == 0:
        return 0
    
    # 중복값의 원소 존재 가능성때문에 리스트가 아닌 딕셔너리 사용
    str1 = str1.upper()
    str2 = str2.upper()
    a = dict()
    b = dict()
    i = 0
    while i < len(str1)-1:
        if str1[i].isalpha() and str1[i+1].isalpha():
            key = str1[i:i+2]
            if key in a.keys():
                tmp = a.get(key) + 1
                a[key] = tmp
            else:
                a[key] = 1
        i += 1
        
    j = 0
    while j < len(str2) -1 :
        if str2[j].isalpha() and str2[j+1].isalpha():
            key = str2[j:j+2]
            if key in b.keys():
                tmp = b.get(key) + 1
                b[key] = tmp
            else:
                b[key] = 1
        j += 1
        
    
    s = []
    for elem in a.keys():
        if elem in b.keys():
            s.append(elem)
    
    # 교집합 속의 원소 갯수 계산 - 중복값 계산 후, 교집합 갯수를 뺌
    same = 0
    for e in s:
        if a[e] >= b[e]:
            same += b[e]
            tmp = a[e] - b[e]
            a[e] = tmp
            b[e] = 0
        else:
            same += a[e]
            tmp = b[e] - a[e]
            a[e] = 0
            b[e] = tmp

    # 합집합 원소갯수 계산 - 중복값 계산 오류 피하기 위해 루프 따로 돌림     
    total = 0
    for elem in a.keys():
        total += a[elem]

    for elem in b.keys():
        total += b[elem]

    total += same
           
    # 교집합 없음
    if total > 0 and same == 0:
        return 0
    
    # 두 집합이 같음
    elif total == same:
        return 65536
    
    # 그외 (일반적인 케이스)
    else:
        r = same / total
        return int(r*65536)
    
