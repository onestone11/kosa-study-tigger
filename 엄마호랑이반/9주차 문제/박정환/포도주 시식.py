n = int(input())

a = [int(input()) for _ in range(n)]

dp = [0] * n
dp[0] = a[0]
if n > 1:
    dp[1] = a[0] + a[1]
if n > 2:
    dp[2] = max(dp[1], a[0] + a[2], a[1] + a[2])
if n > 3:
    for i in range(3, n):
        dp[i] = max(dp[i-1], dp[i-2] + a[i], dp[i-3] + a[i-1] + a[i])

print(dp[n-1])
