def solution(a):
    answer = -1
    min_front = float('inf')
    min_back = float('inf')
    for i in range(len(a)):
        #print("current : {} \tmin_front : {}\tmin_back : {}".format(a[i], min_front, min_back))
        if a[i] < min_front:
            min_front = a[i]
            answer += 1
        if a[-1-i] < min_back:
            min_back = a[-1-i]
            answer += 1
    return answer
