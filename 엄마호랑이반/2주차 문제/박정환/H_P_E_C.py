import sys

n = int(input())
answer = 0
for _ in range(n):
    p, c = map(int, input().split())
    if abs(p - answer) <= c:
        answer += 1
print(answer)