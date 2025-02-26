n = int(input())
a = list(map(int, input().split()))
a.insert(0, 0)
dp = [1] * (n+1)

for i in range(2, n+1):
    for j in range(i):
        if a[i] < a[j]: 
            dp[i] = max(dp[i], dp[j] + 1)
print(max(dp)) 
