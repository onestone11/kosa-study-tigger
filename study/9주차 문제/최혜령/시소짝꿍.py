from collections import Counter
def solution(weights):
    answer, c = 0, Counter(weights)
    for elem in c:
        #answer += c[elem] * (c[elem] - 1) // 2 # nCr = n!/((n-r)!r!)
        value, up = c[elem], 1
        while value > 1:
            up *= value
            value -= 1
        v, m1 = c[elem]-2, 1
        while v > 1:
            m1 *= v
            v -= 1
        answer += up//(m1*2)
        answer += c[elem] * c[elem*2]
        answer += c[elem] * c[elem*(2/3)]
        answer += c[elem] * c[elem*(3/4)]
    return answer
