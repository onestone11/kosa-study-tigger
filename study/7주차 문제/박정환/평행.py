def solution(dots):
    a1, a2, a3, a4 = dots[:4]
    
    if (a3[1]-a1[1]) / (a3[0] - a1[0]) == (a4[1]-a2[1]) / (a4[0] - a2[0]) or (a4[1]-a3[1]) / (a4[0] - a3[0]) == (a2[1]-a1[1]) / (a2[0] - a1[0]):
        return 1
    else:
        return 0
