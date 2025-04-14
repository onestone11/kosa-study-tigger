n, m = map(int, input().split())

a = list(map(int, input().split()))

res = 0

start = 0
end = 1
tmp = a[0]

while end < n:
    if tmp + a[end] <= m:
        tmp += a[end]
        end += 1
        res = max(res, tmp)
    else:
        tmp -= a[start]
        start +=1

print(res)
