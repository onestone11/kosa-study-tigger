n, k = map(int, input().split())

a = list(map(int, input().split()))

answer = 2147000000

start = 0 
cnt = 0

for i in range(n):
    if a[i] == 1:
        cnt += 1

    if cnt == k:
        while a[start] != 1:
            start += 1

        answer = min(answer, i - start + 1)

        start += 1
        cnt -= 1 

print(answer if answer != 2147000000 else -1)
