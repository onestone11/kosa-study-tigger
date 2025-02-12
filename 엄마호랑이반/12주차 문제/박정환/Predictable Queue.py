import sys

n, m = map(int, sys.stdin.readline().split())

a = list(map(int, sys.stdin.readline().split()))
s = []

sum = 0
for i in a:
    sum += i
    s.append(sum)

for _ in range(m):
    t = int(sys.stdin.readline())
    left = 0
    right = n-1
    while left <= right:
        mid = (left + right) // 2
        if s[mid] <= t:
            left = mid + 1
        else:
            right = mid - 1
    print(left)
