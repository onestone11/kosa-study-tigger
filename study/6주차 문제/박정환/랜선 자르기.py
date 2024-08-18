def Count(len):
    cnt = 0
    for i in answer:
        cnt += (i//len)
    return cnt

k, n = map(int, input().split())
answer = []
for i in range(k):
    answer.append(int(input()))
larg = max(answer)
res = 0
lt = 1
rt = larg
while lt <= rt:
    mid = (lt + rt) //2
    if Count(mid) >= n:
        res = mid
        lt = mid + 1
    else:
        rt = mid -1

print(res)
