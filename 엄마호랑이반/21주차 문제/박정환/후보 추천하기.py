n = int(input())
m = int(input())

a = list(map(int, input().split()))

dic = {}

for i in range(m):
    if a[i] in dic: # 사진틀에 해당하는 후보가 있을 경우
        dic[a[i]] += 1

    else: # 사진틀에 해당하는 후보가 없을 경우
        if len(dic) == n: # 비어있는 사진틀이 없는 경우, 가장 오래된 값을 삭제함
            min_v = m # 가장 작은 추천 수
            for key in reversed(dic.keys()): # 추천 수가 같을 경우, 먼저 들어온 학생을 남기고 나중에 들어온 학생을 제거하기 위해
                if min_v >= dic[key]:
                    min_v = dic[key]
                    min_k = key
            
            dic.pop(min_k)

            dic[a[i]] = 1

        else: # 사진틀에 여유가 있을 경우

            dic[a[i]] = 1


answer = list(sorted(dic.keys()))

print(*answer)
