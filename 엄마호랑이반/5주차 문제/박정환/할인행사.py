from collections import Counter

def solution(want, number, discount):
    answer = 0
    dic = {}
    for j in range(len(want)):
        dic[want[j]] = number[j]
        
    for i in range(len(discount) - 9):
        s = discount[i : sum(number) + i]
        s = Counter(s)

        if dic == s:
            answer += 1
    return answer

print(solution(["banana", "apple", "rice", "pork", "pot"], [3, 2, 2, 2, 1], ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]))
