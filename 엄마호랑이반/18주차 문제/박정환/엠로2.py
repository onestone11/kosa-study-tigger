n, k = map(int, input().split())
a = list(map(int, input().split()))

dic =  {}
cnt = 0
res = 0

for i in range(n):
    if a[i] not in dic:
        dic[a[i]] = 1
        cnt +=1
    else:
        dic[a[i]] += 1

    if i >= k:
        dic[a[i-k]] -= 1
        if dic[a[i - k]] == 0:
            cnt -= 1

    res = max(res, cnt)

print(res)
