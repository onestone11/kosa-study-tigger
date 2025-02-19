n = int(input())
a = list(map(int, input().split()))
dp = [0] * (n+1)

for i in range(n+1):
    for k in range(i-1, -1, -1):
        diff = max(a[k:i]) - min(a[k:i])
        dp[i] = max(dp[k] + diff, dp[i])
        
print(dp[-1])
