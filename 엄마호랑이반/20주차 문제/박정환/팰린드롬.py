import sys
input = sys.stdin.readline

n = int(input())

a = list(map(int, input().split()))

m = int(input())
dp = [[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n-i):
        end = j + i
        if end == j:
            dp[j][end] = 1
        elif a[j] == a[end]:
            if end - j == 1:
                dp[j][end] = 1
            elif dp[j+1][end-1] == 1:
                dp[j][end] = 1

for _ in range(m):
    s, e = map(int, input().split())
    print(dp[s-1][e-1])
