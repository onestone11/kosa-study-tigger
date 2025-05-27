n, k = map(int, input().split())

a = [int(input()) for _ in range(n)]
dp = [100000] * (k+1)
dp[0] = 0

for i in a:
    for j in range(i, k+1):
        dp[j] = min(dp[j], dp[j - i] + 1)

if dp[k] == 100000:
    print(-1)
else:
    print(dp[k])
